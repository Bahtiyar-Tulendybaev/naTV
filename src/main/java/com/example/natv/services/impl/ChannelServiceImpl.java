package com.example.natv.services.impl;

import com.example.natv.mappers.ChannelMapper;
import com.example.natv.models.dto.Calculate.CalculateDto;
import com.example.natv.models.dto.ChannelDto;
import com.example.natv.models.dto.RequestDto1.ChannelListDto;
import com.example.natv.models.dto.RequestDto1.DiscountsDto;
import com.example.natv.models.entities.Channel;
import com.example.natv.models.entities.Discount;
import com.example.natv.repository.ChannelRepo;
import com.example.natv.repository.DiscountRepo;
import com.example.natv.repository.OrderRepo;
import com.example.natv.repository.PriceRepo;
import com.example.natv.services.ChannelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepo channelRepo;
    private final PriceRepo priceRepo;
    private final DiscountRepo discountRepo;
    private final OrderRepo orderRepo;


    public ChannelServiceImpl(ChannelRepo channelRepo, PriceRepo priceRepo, DiscountRepo discountRepo, OrderRepo orderRepo) {
        this.channelRepo = channelRepo;
        this.priceRepo = priceRepo;
        this.discountRepo = discountRepo;
        this.orderRepo = orderRepo;

    }

    @Override
    public ChannelDto save(ChannelDto channelDto) {
        Channel channel = ChannelMapper.INSTANCE.channelDtoToChannel(channelDto);
        channel = channelRepo.save(channel);
        channelDto = ChannelMapper.INSTANCE.channelToChannelDto(channel);
        return channelDto;
    }

    @Override
    public List<ChannelListDto> findAll (Pageable pageable) {
        List<ChannelListDto> channelListDtos = new ArrayList<>();
        Page<Channel> channelList = channelRepo.findAllByActive(pageable);
        for (Channel item : channelList) {
            ChannelListDto channelListDto = new ChannelListDto();
            channelListDto.setChannelName(item.getChannelName());
            channelListDto.setLogo(item.getLogoPath());
            if (priceRepo.getPrice(item.getId()) != null) {
                if (getDiscount(item.getId()) != null) {
                    channelListDto.setPricePerLetter(priceRepo.getPrice(item.getId()).getPricePerSymbol());
                    channelListDto.setDiscounts(getDiscount(item.getId()));
                }
            }
            channelListDtos.add(channelListDto);

        }


        return channelListDtos;
    }

    @Override
    public CalculateDto calculate(CalculateDto calculateDto ) {
        calculateDto.setText(calculateDto.getText());
        calculateDto.setDaysCount(calculateDto.getDaysCount());
        calculateDto.setChannelId(calculateDto.getChannelId());
        System.err.println(calculateDto.getChannelId());
        System.err.println(channelRepo.findByActive(calculateDto.getChannelId()));

        boolean active = channelRepo.findByActive(calculateDto.getChannelId());


            if (active == false) {
            throw new RuntimeException("The channel is not active!");
        }
        System.err.println("???????");
        getPriceAndDiscount(calculateDto);
        return calculateDto;
    }

    @Override
    public Optional <Channel> findById(Long id) {

        return channelRepo.findById(id);
    }

    private void getPriceAndDiscount(CalculateDto calculateDto) {
        if (calculateDto.getText().replaceAll(" ", "").length() < 20) {
            throw new RuntimeException("The quantity of symbols should be from 20");
        }
        calculateDto.setPrice(calculateDto.getText().replaceAll(" ", "").length() *
                priceRepo.getPricePerSymbol(calculateDto.getChannelId()) * calculateDto.getDaysCount());
        if (calculateDto.getDaysCount() >= 3 && calculateDto.getDaysCount() < 7) {
            calculateDto.setPriceWithDiscount(calculateDto.getPrice() - calculateDto.getPrice() * 0.05);
        }
        if (calculateDto.getDaysCount() >= 7 && calculateDto.getDaysCount() < 10) {
            calculateDto.setPriceWithDiscount(calculateDto.getPrice() - calculateDto.getPrice() * 0.1);
        }
        if (calculateDto.getDaysCount() >= 10) {
            calculateDto.setPriceWithDiscount(calculateDto.getPrice() - calculateDto.getPrice() * 0.15);
        }
    }


    private List <DiscountsDto> getDiscount(Long id) {
        List<Discount> discounts = discountRepo.getDiscounts(id);
        List<DiscountsDto> newDiscountsDto = new ArrayList<>();
        for (Discount item : discounts) {
            if (item.getStartDate().before(new Date()) &&
                    item.getEndDate().after(new Date())) {
                DiscountsDto discountsDto = new DiscountsDto();
                discountsDto.setDiscount(item.getDiscount());
                discountsDto.setFromDayCount(item.getDiscountDays());
                newDiscountsDto.add(discountsDto);
            }

        }
        return newDiscountsDto;

    }
}

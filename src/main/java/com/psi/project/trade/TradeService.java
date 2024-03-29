package com.psi.project.trade;

import com.psi.project.item.ItemRepository;
import com.psi.project.item.valueobjects.StatusValidator;
import com.psi.project.trade.dtos.TradeCreateDTO;
import com.psi.project.trade.dtos.TradeResponseDTO;
import com.psi.project.trade.valueobjects.ValueValidator;
import com.psi.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TradeService {

    private final static Integer PAGESIZE = 5;

    private final TradeRepository tradeRepository;

    private final TradeMapper tradeMapper;

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    public TradeService(
            TradeRepository tradeRepository,
            TradeMapper tradeMapper,
            ItemRepository itemRepository,
            UserRepository userRepository
    ) {
        this.tradeRepository = tradeRepository;
        this.tradeMapper = tradeMapper;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public List<TradeResponseDTO> getTradesByBuyerId(Long buyerId, Integer page) {
        Pageable sortedByValue = PageRequest.of(page, PAGESIZE, Sort.Direction.ASC, "value");

        Page<TradeEntity> trades = tradeRepository.findAllByBuyerId(buyerId, sortedByValue);
        return trades.stream().map(tradeMapper::fromTradeEntityToTradeResponseDTO).collect(Collectors.toList());
    }

    public TradeResponseDTO getTradeById(Long id) {
        var trade =
                tradeRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Trade with id: " + id + " does not exist!"));
        return tradeMapper.fromTradeEntityToTradeResponseDTO(trade);
    }

    public TradeEntity getTradeEntityById(Long id) {
        return tradeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Trade with id: " + id + " does not exist!"));
    }

    public String addTrade(TradeCreateDTO tradeCreateDTO) {
        var trade = tradeMapper.fromTradeCreateDTOToTradeEntity(tradeCreateDTO);
        var item = itemRepository.findItemEntityById(trade.getItemEntity().getId());
        item.setStatus(StatusValidator.UNAVAILABLE);
        trade.setUserId(userRepository.findUser(tradeCreateDTO.userId()));
        trade.setItemEntity(item);
        itemRepository.save(item);
        tradeRepository.save(trade);

        return "Successfully bought an item!";
    }

    public String updateTradeById(Long id, Double value) {
        var trade = tradeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Trade with id: " + id + " does not exist!"));
        trade.setValue(new ValueValidator(value));
        tradeRepository.save(trade);
        return "Trade with id: " + id + " updated successfully!";
    }

    public String deleteTrade(Long id) {
        var trade = tradeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Trade with id: " + id + " does not exist!"));
        tradeRepository.delete(trade);
        return "Trade with id: " + id + " deleted successfully!";
    }

}

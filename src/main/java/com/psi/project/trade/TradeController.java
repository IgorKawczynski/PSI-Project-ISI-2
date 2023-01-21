package com.psi.project.trade;

import com.psi.project.trade.dtos.TradeCreateDTO;
import com.psi.project.trade.dtos.TradeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TradeResponseDTO> getTrades() {
        return tradeService.getTrades();
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.FOUND)
    public TradeResponseDTO getTradeById(@RequestParam("id") Long id) {
        return tradeService.getTradeById(id);
    }

    @GetMapping("/get-trade")
    @ResponseStatus(HttpStatus.FOUND)
    public TradeEntity getTradeEntityById(@RequestParam("id") Long id) {
        return tradeService.getTradeEntityById(id);
    }

    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String buyItem(@RequestBody TradeCreateDTO tradeCreateDTO) {
        return tradeService.addTrade(tradeCreateDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateTradeById(@PathVariable Long id, @RequestBody Double value) {
        return tradeService.updateTradeById(id, value);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteTradeById (@PathVariable Long id) {
        return tradeService.deleteTrade(id);
    }

}

package com.psi.project.opinion;

import com.psi.project.opinion.dtos.OpinionRequestDTO;
import com.psi.project.opinion.dtos.OpinionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opinion")
public class OpinionController {

    private final OpinionService opinionService;

    @Autowired
    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<OpinionResponseDTO> getOpinions(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        return opinionService.getOpinions(page);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.FOUND)
    public OpinionResponseDTO getOpinionById(@RequestParam("id") Long id) {
        return opinionService.getOpinionById(id);
    }

    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String addOpinion(@RequestBody OpinionRequestDTO opinionRequestDTO) {
       return opinionService.addOpinion(opinionRequestDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateOpinionById(@PathVariable Long id, @RequestParam Integer rate, @RequestParam String description) {
        return opinionService.updateOpinionById(id, rate, description);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteOpinonById(@PathVariable Long id) {
        return opinionService.deleteOpinion(id);
    }

}

package com.psi.project.graphql.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemGRAPHQLService {

    @Autowired
    private ItemGRAPHQLRepository itemGRAPHQLRepository;

    public List<ItemGRAPHQL> getAllItems() {
        return itemGRAPHQLRepository.findAll();
    }

    public ItemGRAPHQL getItemById(Integer id) {
        return itemGRAPHQLRepository.findItemGRAPHQLById(id);
    }

    public ItemGRAPHQL addItem(ItemGRAPHQL item) {
        return itemGRAPHQLRepository.save(item);
    }

    public ItemGRAPHQL updateItemById(Integer id, String name, Integer cost) {
        var item = itemGRAPHQLRepository.findItemGRAPHQLById(id);
        item.setName(name);
        item.setCost(cost);
        return item;
    }

    public Integer deleteItemById(Integer id) {
        itemGRAPHQLRepository.deleteById(id);
        return id;
    }
}

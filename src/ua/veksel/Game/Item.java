package ua.veksel.Game;

public class Item {
    public  enum ItemType { Consumables, InfConsumables, Quest, Armor, Weapon };
    private String name;
    private ItemType type;
    public ItemType getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public Item(String _name, ItemType _type){
name=_name;
type=_type;

    }

}

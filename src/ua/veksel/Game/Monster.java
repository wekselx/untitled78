package ua.veksel.Game;
public class Monster extends GameCharacter {

    public Monster(String _charClass, String _name,int _strenght, int _dexterity, int _endurance)
    {
        super(_charClass, _name, _strenght, _dexterity, _endurance);
        myInv = new Inventory();
        myInv.add(new Item("Слабое зелье лечения", Item.ItemType.Consumables));
        myInv.addSomeCoins(100);
    }
    public void lvlUp(int _1){
        for(int i=0;i<_1;i++)
        {
        ShowInfo();
        strenght+=Base_strenght*0.3f;
        dexterity+=Base_dexterity*0.3f;
        endurance+=Base_endurance*0.3f;
          CalculateSecondaryParameters();
            hp = hpMax;
            ShowInfo();
    }}

}
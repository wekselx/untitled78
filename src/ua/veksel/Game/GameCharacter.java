package ua.veksel.Game;



public class GameCharacter implements Cloneable  {


    protected String name;
    public String getName()
    {
        return name;
    }
    protected String charClass;

    protected int hp;
    protected int hpMax;
    public int getHpMax()
    {
        return hpMax;
    }
    protected  int Base_strenght;
    protected int Base_dexterity;
    protected int Base_endurance;
    protected  int strenght;
    protected int dexterity;
    protected int endurance;

    protected int attack;
    protected int defense;
    protected int critChance;
    protected float critMult;
    protected int chanceAvoid;
    protected int level;
    protected boolean blockStance;
    protected boolean life;
    public boolean isAlive()
    {
        return life;
    }
    protected Inventory myInv;

    public GameCharacter(String _charClass, String _name, int _strenght, int _dexterity, int _endurance)
    {
        name = _name;
        charClass = _charClass;
        strenght =  _strenght;
        dexterity = _dexterity;
        endurance = _endurance;
        Base_strenght =  _strenght;
        Base_dexterity = _dexterity;
       Base_endurance = _endurance;
        CalculateSecondaryParameters();
        hp = hpMax;
        //critChance = 10;
        level = 1;
        life = true;
        blockStance = false;
    }
    public void CalculateSecondaryParameters(){
        attack=strenght*2;
        hpMax= endurance*50;
        defense=(int)((strenght+dexterity)/4.0f);
        critChance=dexterity*3;
        critMult=1.2f+(float)(dexterity/2.0f);
        chanceAvoid =2+(int) (dexterity/5.0f);
    }


    public void ShowInfo()
    {
        System.out.println("Имя: " + name + " Здоровье: " + hp + "/" + hpMax);
    }

    public void setBlockStance()
    {
        blockStance = true;
        System.out.println(name + " стал в защитную стойку");
    }
    public void cure(int _val)
    {
        hp += _val;
        if(hp>hpMax) hp = hpMax;
    }

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println("Клонирование невозможно");
            return this;
        }
    }

    public void makeNewRound()
    {
        blockStance = false;
    }

    public int makeAttack()
    {
        int minAttack = (int)(attack * 0.8f);
        int deltaAttack = (int)(attack * 0.4f);
        int currentAttack = minAttack + Utilites.rand.nextInt(deltaAttack);
        if(Utilites.rand.nextInt(100) < critChance)
        {
            currentAttack = (int)(currentAttack*critMult);
            System.out.println(name + " нанес критический урон в размере " + currentAttack + " ед. урона");
        }
        else
            System.out.println(name + " нанес " + currentAttack + " ед. урона");
        return currentAttack;
    }

    public void getDamage(int _inputDamage)
    {
        if (Utilites.rand.nextInt(100)<chanceAvoid){
            System.out.println(name+"Уклонение успешно");
        }
        else {
        _inputDamage -= Utilites.rand.nextInt(defense);
        if (blockStance)
        {
            System.out.println(name + " дополнительно заблокировал " + defense + " ед. урона в защитной стойке");
            _inputDamage -= Utilites.rand.nextInt(defense);;
        }
        if (_inputDamage < 0) _inputDamage = 0;
        System.out.println(name + " получил " + _inputDamage + " ед. урона");
        hp -= _inputDamage;
        if(hp < 1)
            life = false;
    }
}
    public void useItem(String _item)
    {
        switch(_item)
        {
            case "Слабое зелье лечения":
            cure(500);
            System.out.println(name + " пополнил здоровье на 500 ед.");
            break;
            case "слаб камень здоровья":
                cure(400);
                System.out.println(name + " пополнил здоровье на 500 ед.");
                break;
        }
    }
    public void fullFeal(){
  hp=hpMax;

    }
}

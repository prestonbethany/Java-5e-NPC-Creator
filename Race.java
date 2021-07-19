// I don't want to abuse the processor to set and call data that doesn't need to be sanitized.
// Because these values are merely pass-throughs, they are all public.
public class Race {
    public String bookTag;
    public String name;
    public int strengthBonus = 0;
    public int dexterityBonus = 0;
    public int constitutionBonus = 0;
    public int intelligenceBonus = 0;
    public int wisdomBonus = 0;
    public int charismaBonus = 0;
    public String traits = null; 
    
    public Race() {}
    
    public Race(String raceName) {
        this.name = raceName;
    }

    public Race(String bookTag, String raceName, int strengthBonus, int dexterityBonus, int constitutionBonus,
            int intelligenceBonus, int wisdomBonus, int charismaBonus, String raceTraits) {
        this.bookTag = bookTag;
        this.name = raceName;
        this.strengthBonus = strengthBonus;
        this.dexterityBonus = dexterityBonus;
        this.constitutionBonus = constitutionBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.wisdomBonus = wisdomBonus;
        this.charismaBonus = charismaBonus;
        this.traits = raceTraits;
    }
}
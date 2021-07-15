// I don't want to abuse the processor to set and call data that doesn't need to be sanitized.
// Because these values are merely pass-throughs, they are all public.
public class CharacterInfo {
    public String characterName;
    public Race race;
    public CharacterClass CharacterClass;
    public int strength;
    public int dexterity;
    public int constitution;
    public int intelligence;
    public int wisdom;
    public int charisma;
}

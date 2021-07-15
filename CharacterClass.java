// I don't want to abuse the processor to set and call data that doesn't need to be sanitized.
// Because these values are merely pass-throughs, they are all public.
public class CharacterClass {
    public String name;
    public int primaryStat;
    public String classTraits;

    public CharacterClass(String className) {
        this.name = className;
    }

    public CharacterClass(String className, int primaryStat, String classTraits) {
        this.name = className;
        this.primaryStat = primaryStat;
        this.classTraits = classTraits;
    }
}
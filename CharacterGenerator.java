import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CharacterGenerator { 
    //  quickSort
    //
    //  This public-domain C implementation by Darel Rex Finley.
    //  Re-formatted by William Croft.
    //  Adapted to Java by Preston Bethany.
    //  * This function assumes it is called with valid parameters.
    //
    //  * Example calls:
    //    quickSort(&myArray[0],5); // sorts elements 0, 1, 2, 3, and 4
    //    quickSort(&myArray[3],5); // sorts elements 3, 4, 5, 6, and 7

    private static void quickSort(int[] arr) {
        final int MAX_LEVELS = 300;
        int piv;
        int[] beg = new int[MAX_LEVELS];
        int[] end = new int[MAX_LEVELS];
        int i = 0;
        int left;
        int right;
        int swap;
            beg[0] = 0;
            end[0] = arr.length;
            while (i >= 0)
            {
                left = beg[i];
                right = end[i] - 1;
                if (left < right)
                {
                    piv = arr[left];
                    while (left < right)
                    {
                        while (arr[right] >= piv && left < right)
                        {
                            right--;
                        }
                        if (left < right)
                        {
                            arr[left++] = arr[right];
                        }
                        while (arr[left] <= piv && left < right)
                        {
                            left++;
                        }
                        if (left < right)
                        {
                            arr[right--] = arr[left];
                        }
                    }
                    arr[left] = piv;
                    beg[i + 1] = left + 1;
                    end[i + 1] = end[i];
                    end[i++] = left;
                    if (end[i] - beg[i] > end[i - 1] - beg[i - 1])
                    {
                        swap = beg[i];
                        beg[i] = beg[i - 1];
                        beg[i - 1] = swap;
                        swap = end[i];
                        end[i] = end[i - 1];
                        end[i - 1] = swap;
                    }
                }
                else
                {
                    i--;
                }
            }
        }

        private static int statRoller() {
            int[] myArray = new int[4];
            int sum = 0;
            for(int i = 0; i < 4; ++i) {
                myArray[i] = (int) (1 + Math.random() * 5);
            }
            quickSort(myArray);
            for(int i = 3; i > 0; --i) {
                sum += myArray[i];
            }
            return sum;
        }

        public static int getIntFromUser(BufferedReader br) {
            try {
                String input = br.readLine();
                if (input.trim().equals("")) {
                    return -1;
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println("This field must be a number.");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return -1;
        }

        // This swap is actually more efficient than a XOR swap, because the math is performed as the variables are loaded.
        // The traditional XOR swap must be executed sequentially, 
        // wherein the program loads each individual number into memory before performing math on them.
        /*
        private static void statSwap(int prime, int other) {
            int temp = prime;
            prime = other;
            other = temp;
        }
        
        int getPriority() {
            char priority[3];
            getSafeUserInput(priority, 3);
            int statNum = atoi(priority);
            return statNum;
        }
    */

    private static ArrayList<Race> listOfRaces = new ArrayList<Race>();

    static {
        listOfRaces.add(new Race("Aarakocra"));
        listOfRaces.add(new Race("Aasimar"));
        listOfRaces.add(new Race("Bugbear"));
        listOfRaces.add(new Race("Centaur"));
        listOfRaces.add(new Race("Changling"));
        listOfRaces.add(new Race("Dragonborn", 2, 0, 0, 0, 0, 1, "Draconic Ancestry, Breath Weapon, Damage Resistance"));
        listOfRaces.add(new Race("Dwarf", 0, 0, 2, 0, 0, 0, "Darkvision, Dwarven Resilience, Dwarven Combat Training, Stonecunning"));
        listOfRaces.add(new Race("Elf", 0, 2, 0, 0, 0, 0, "Darkvision, Keen Senses, Fey Ancestry, Trance"));
        listOfRaces.add(new Race("Feral Tiefling"));
        listOfRaces.add(new Race("Firbolg"));
        listOfRaces.add(new Race("Genasi"));
        listOfRaces.add(new Race("Gith"));
        listOfRaces.add(new Race("Gnome", 0, 0, 0, 2, 0, 0, "Darkvision, Gnome Cunning"));
        listOfRaces.add(new Race("Goblin"));
        listOfRaces.add(new Race("Goliath"));
        listOfRaces.add(new Race("Grung"));
        listOfRaces.add(new Race("Half Orc", 2, 0, 1, 0, 0, 0, "Darkvision, Menacing, Relentless Endurance, Savage Attacks"));
        //TODO (Preston Bethany): Half-Elves get 2 separate floating stat bonuses of + 1 to be chosen by the user.
        listOfRaces.add(new Race("Half Elf", 0, 0, 0, 0, 0, 2, "Darkvision, Fey Ancestry, Skill Versatility"));
        listOfRaces.add(new Race("Halfling", 0, 2, 0, 0 , 0, 0, "Lucky, Brave, Halfling Nimbleness"));
        listOfRaces.add(new Race("Hobgoblin"));
        listOfRaces.add(new Race("Human", 1, 1, 1, 1, 1, 1, null));
        listOfRaces.add(new Race("Kalashtar"));
        listOfRaces.add(new Race("Kenku"));
        listOfRaces.add(new Race("Kobold"));
        listOfRaces.add(new Race("Leonin"));
        listOfRaces.add(new Race("Lizardfolk"));
        listOfRaces.add(new Race("Locathah"));
        listOfRaces.add(new Race("Loxodon"));
        listOfRaces.add(new Race("Minotaur"));
        listOfRaces.add(new Race("Orc"));
        listOfRaces.add(new Race("Orc Of Eberron"));
        listOfRaces.add(new Race("Orc Of Exandria"));
        listOfRaces.add(new Race("Satyr"));
        listOfRaces.add(new Race("Shifter"));
        listOfRaces.add(new Race("Simic Hybrid"));
        listOfRaces.add(new Race("Tabaxi"));
        listOfRaces.add(new Race("Tiefling"));
        listOfRaces.add(new Race("Titan"));
        listOfRaces.add(new Race("Tortle"));
        listOfRaces.add(new Race("Vedalken"));
        listOfRaces.add(new Race("Verdan"));
        listOfRaces.add(new Race("Warforged"));
        listOfRaces.add(new Race("Yuan-Ti Pureblood"));
    }

    private static ArrayList<CharacterClass> listOfClasses = new ArrayList<CharacterClass>();

    static {
        listOfClasses.add(new CharacterClass("Artificer"));
        listOfClasses.add(new CharacterClass("Barbarian"));
        listOfClasses.add(new CharacterClass("Bard"));
        listOfClasses.add(new CharacterClass("Blood Hunter"));
        listOfClasses.add(new CharacterClass("Cleric"));
        listOfClasses.add(new CharacterClass("Druid"));
        listOfClasses.add(new CharacterClass("Fighter"));
        listOfClasses.add(new CharacterClass("Monk"));
        listOfClasses.add(new CharacterClass("Paladin"));
        listOfClasses.add(new CharacterClass("Ranger"));
        listOfClasses.add(new CharacterClass("Rogue"));
        listOfClasses.add(new CharacterClass("Sorcerer"));
        listOfClasses.add(new CharacterClass("Warlock"));
        listOfClasses.add(new CharacterClass("Wizard"));
    }
    public static void main(String[] args) {
        
        System.out.print("Please input your character's name: ");
        String characterName = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            characterName = br.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 
        if (characterName != null) {
            System.out.println("Your name is " + characterName);
            CharacterInfo theCharacter = new CharacterInfo();
            theCharacter.characterName = characterName;
            System.out.println("Rolling stats...");

            int coreStats[] = new int[6];
            coreStats[0] = statRoller();
            coreStats[1] = statRoller();
            coreStats[2] = statRoller();
            coreStats[3] = statRoller();
            coreStats[4] = statRoller();
            coreStats[5] = statRoller();
            quickSort(coreStats);

            System.out.print("Your first roll is " + coreStats[0] + "\n" + "Your second roll is " + coreStats[1] + "\n" + "Your third roll is " +
                    coreStats[2] + "\n" + "Your fourth roll is " + coreStats[3] + "\n" + "Your fifth roll is " + coreStats[4] + "\n" +
                    "Your sixth roll is " + coreStats[5] + "\n Please prioritize your stats by entering a number \"1\" through \"6\" in the following fields.\nStrength priority: ");
            int strengthInput = 0;
            int dexterityInput = 0;
            int constitutionInput = 0;
            int intelligenceInput = 0;
            int wisdomInput = 0;
            int charismaInput = 0;
            for(;;) {
                strengthInput = getIntFromUser(br);
                if (strengthInput > 0 && strengthInput < 7) {
                    switch (strengthInput) {
                        case 1: theCharacter.strength = coreStats[5];
                        break;
                        case 2: theCharacter.strength = coreStats[4];
                        break;
                        case 3: theCharacter.strength = coreStats[3];
                        break;
                        case 4: theCharacter.strength = coreStats[2];
                        break;
                        case 5: theCharacter.strength = coreStats[1];
                        break;
                        case 6: theCharacter.strength = coreStats[0];
                        break;
                    }
                
                    System.out.print("Dexterity priority: ");
                    dexterityInput = getIntFromUser(br);
                    if (dexterityInput > 0 && dexterityInput < 7 && dexterityInput != strengthInput) {
                        switch (dexterityInput) {
                            case 1: theCharacter.dexterity = coreStats[5];
                            break;
                            case 2: theCharacter.dexterity = coreStats[4];
                            break;
                            case 3: theCharacter.dexterity = coreStats[3];
                            break;
                            case 4: theCharacter.dexterity = coreStats[2];
                            break;
                            case 5: theCharacter.dexterity = coreStats[1];
                            break;
                            case 6: theCharacter.dexterity = coreStats[0];
                            break;
                        }
                    

                        System.out.print("Constitution priority: ");
                        constitutionInput = getIntFromUser(br);
                        if (constitutionInput > 0 && constitutionInput < 7 && constitutionInput != strengthInput && constitutionInput != dexterityInput) {
                            switch (constitutionInput) {
                                case 1: theCharacter.constitution = coreStats[5];
                                break;
                                case 2: theCharacter.constitution = coreStats[4];
                                break;
                                case 3: theCharacter.constitution = coreStats[3];
                                break;
                                case 4: theCharacter.constitution = coreStats[2];
                                break;
                                case 5: theCharacter.constitution = coreStats[1];
                                break;
                                case 6: theCharacter.constitution = coreStats[0];
                                break;
                            }
                        
                            System.out.print("Intelligence priority: ");
                            intelligenceInput = getIntFromUser(br);
                            if (intelligenceInput > 0 && intelligenceInput < 7 && intelligenceInput != strengthInput 
                                    && intelligenceInput != dexterityInput && intelligenceInput != constitutionInput) {
                                switch (intelligenceInput) {
                                    case 1: theCharacter.intelligence = coreStats[5];
                                    break;
                                    case 2: theCharacter.intelligence = coreStats[4];
                                    break;
                                    case 3: theCharacter.intelligence = coreStats[3];
                                    break;
                                    case 4: theCharacter.intelligence = coreStats[2];
                                    break;
                                    case 5: theCharacter.intelligence = coreStats[1];
                                    break;
                                    case 6: theCharacter.intelligence = coreStats[0];
                                    break;
                                }
                            
                                System.out.print("Wisdom priority: ");
                                wisdomInput = getIntFromUser(br);
                                if (wisdomInput > 0 && wisdomInput < 7 && wisdomInput != strengthInput 
                                        && wisdomInput != dexterityInput && wisdomInput != constitutionInput && wisdomInput != intelligenceInput) {
                                    switch (wisdomInput) {
                                        case 1: theCharacter.wisdom = coreStats[5];
                                        break;
                                        case 2: theCharacter.wisdom = coreStats[4];
                                        break;
                                        case 3: theCharacter.wisdom = coreStats[3];
                                        break;
                                        case 4: theCharacter.wisdom = coreStats[2];
                                        break;
                                        case 5: theCharacter.wisdom = coreStats[1];
                                        break;
                                        case 6: theCharacter.wisdom = coreStats[0];
                                        break;
                                    }
                                
                                    System.out.print("Charisma priority: ");
                                    charismaInput = getIntFromUser(br);
                                    if (charismaInput > 0 && charismaInput < 7 && charismaInput != strengthInput 
                                            && charismaInput != dexterityInput && charismaInput != constitutionInput 
                                            && charismaInput != intelligenceInput && charismaInput != wisdomInput) {
                                        switch (charismaInput) {
                                            case 1: theCharacter.charisma = coreStats[5];
                                            break;
                                            case 2: theCharacter.charisma = coreStats[4];
                                            break;
                                            case 3: theCharacter.charisma = coreStats[3];
                                            break;
                                            case 4: theCharacter.charisma = coreStats[2];
                                            break;
                                            case 5: theCharacter.charisma = coreStats[1];
                                            break;
                                            case 6: theCharacter.charisma = coreStats[0];
                                            break;
                                        }
                                        break; //Exits loop only once all priorities have been entered correctly.
                                    }//if (charismaInput...
                                }//if (wisdomInput...
                            }//if (intelligenceInput...
                        }//if (constitutionInput...
                    }//if (dexterityInput...
                }//if (strengthInput > 0 && strengthInput < 7)
                System.out.print("Priorities entered incorrectly. Try again.\nStrength priority: ");
            }//while (!prioritySet)
            System.out.print("Your strength is " + theCharacter.strength + "\nYour dexterity is " + theCharacter.dexterity + "\nYour constitution is " + theCharacter.constitution +
            "\nYour intelligence is " + theCharacter.intelligence + "\nYour wisdom is " + theCharacter.wisdom +  "\nYour charisma is " + theCharacter.charisma);

            StringBuilder message = new StringBuilder("\nPlease type the corresponding number from the following races (Full support currently only for PHB races): ");
            for (int i = 0; i < listOfRaces.size(); i++) {
                message.append("\n").append(i).append(" - ").append(listOfRaces.get(i).name);
            } 
            System.out.print(message.append("\nType here: ").toString());
            for(;;) { 
                int userChoice = getIntFromUser(br);
                if (userChoice > -1 && userChoice < listOfRaces.size()) {
                    theCharacter.race = listOfRaces.get(userChoice);
                    break;
                }
                System.out.print("That was not a number associated with a race.\nType here: ");
            }

            if (theCharacter.race != null) {
                message.replace(0, message.length(), "The race " + theCharacter.race.name + " gains the following ability score bonuses.");
                if (theCharacter.race.strengthBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.strengthBonus).append(" to strength.");
                }
                if (theCharacter.race.dexterityBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.dexterityBonus).append(" to dexterity.");
                }
                if (theCharacter.race.constitutionBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.constitutionBonus).append(" to constitution.");
                }
                if (theCharacter.race.intelligenceBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.intelligenceBonus).append(" to intelligence.");
                }
                if (theCharacter.race.wisdomBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.wisdomBonus).append(" to wisdom.");
                }
                if (theCharacter.race.charismaBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.charismaBonus).append(" to charisma.");
                } 
                if (theCharacter.race.strengthBonus == 0 && theCharacter.race.dexterityBonus == 0 && theCharacter.race.constitutionBonus == 0 && 
                        theCharacter.race.intelligenceBonus == 0 && theCharacter.race.wisdomBonus == 0 && theCharacter.race.charismaBonus == 0) { 
                            message.append("\n").append("No ability score bonuses found.");
                }
                System.out.print(message);
                //TODO (Preston Bethany): Add racial ability score bonuses to totals.
                System.out.println("\nYour ability score bonuses have been added to your base ability scores.\n");
                System.out.print("Your total strength is " + theCharacter.strength + "\n" + "Your total dexterity is " + theCharacter.dexterity + "\n" + "Your total constitution is " +
                theCharacter.constitution + "\n" + "Your total intelligence is " + theCharacter.intelligence + "\n" + "Your total wisdom is " + theCharacter.wisdom + "\n" +
                "Your total charisma is " + theCharacter.charisma + "\n");

            } //if (theCharacter.race != null)
        } //if (characterName != null)
    }
}
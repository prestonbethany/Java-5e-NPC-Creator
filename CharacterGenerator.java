import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
public class CharacterGenerator { 
    //  quickSort
    //
    //  This public-domain C implementation by Darel Rex Finley.
    //  Re-formatted by William Croft.
    //  Adapted to Java by Cain.
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
                myArray[i] = (int) (Math.random() * 6) + 1;
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

        public static String getStringFromUser(BufferedReader br) {
            try {
                String input = br.readLine();
                return input; 
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } return "Error with input.";
        }

        public static void getRaceStats(CharacterInfo theCharacter, BufferedReader br, int statBonusTotal) {
            for(;;) {
                System.out.print("\nChoose from the following.\n1- Strength (currently +" + theCharacter.race.strengthBonus + ")" 
                + "\n2- Dexterity (currently +" + theCharacter.race.dexterityBonus + ")" 
                + "\n3- Constitution (currently +" + theCharacter.race.constitutionBonus + ")" 
                + "\n4- Intellignece (currently +" + theCharacter.race.intelligenceBonus + ")" 
                + "\n5- Wisdom (currently +" + theCharacter.race.wisdomBonus + ")" 
                + "\n6- Charisma (currently +" + theCharacter.race.charismaBonus + ")");
                System.out.print("\nType here: ");
                int statNum = getIntFromUser(br);
                if (statNum == 1 && theCharacter.race.strengthBonus == 0){
                    System.out.print("\nYou have selected Strength.\n");
                    theCharacter.race.strengthBonus = 1;
                } else if (statNum == 2 && theCharacter.race.dexterityBonus == 0){
                    System.out.print("\nYou have selected Dexterity.\n");
                    theCharacter.race.dexterityBonus = 1;
                } else if (statNum == 3 && theCharacter.race.constitutionBonus == 0){
                    System.out.print("\nYou have selected Constitution.\n");
                    theCharacter.race.constitutionBonus = 1;
                } else if (statNum == 4 && theCharacter.race.intelligenceBonus == 0){
                    System.out.print("\nYou have selected Intelligence.\n");
                    theCharacter.race.intelligenceBonus = 1;
                } else if (statNum == 5 && theCharacter.race.wisdomBonus == 0){
                    System.out.print("\nYou have selected Wisdom.\n");
                    theCharacter.race.wisdomBonus = 1;
                } else if (statNum == 6 && theCharacter.race.charismaBonus == 0) {
                    System.out.print("\nYou have selected Charisma.\n");
                    theCharacter.race.charismaBonus = 1;
                } else {
                    System.out.print("\nThat selection is invalid. Please note that if there's already a bonus in that stat, you can't place another one in it."
                    + "\nPlease Try again.\n");
                } 
                if (theCharacter.race.strengthBonus + theCharacter.race.dexterityBonus + theCharacter.race.constitutionBonus 
                + theCharacter.race.intelligenceBonus + theCharacter.race.wisdomBonus + theCharacter.race.charismaBonus == statBonusTotal){
                    break;
                }
            }
        }

        public static void printCharacter(StringBuilder message, String characterName) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("./characters/" + characterName + ".txt"));
                writer.write(message.toString());
                writer.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (IndexOutOfBoundsException ioobe) {
                ioobe.printStackTrace();
            }
            System.out.println("Thank you for using my character generator. You will find your character at this program's sub directory, under ./characters/"
            + characterName + ".txt");
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
        //Race(String bookTag, String raceName, int strengthBonus, int dexterityBonus, int constitutionBonus,
        //    int intelligenceBonus, int wisdomBonus, int charismaBonus, String raceTraits);
        listOfRaces.add(new Race("EEPC", "Aarakocra", 0, 2, 0, 0, 1, 0, "Flight, Talons"));
        listOfRaces.add(new Race("VGtM", "Aasimar", 0, 0, 0, 0, 0, 2, "Darkvision, Celestial Resistance, Healing Hands, Light Bearer"));
        listOfRaces.add(new Race("VGtM", "Bugbear", 2, 1, 0, 0, 0, 0, "Darkvision, Long-Limbed, Powerful Build, Sneaky, Surprise Attack"));
        listOfRaces.add(new Race("GGtR", "Centaur", 2, 0, 0, 0, 1, 0, "Fey, Charge, Hooves, Equine Build, Survivor"));
        listOfRaces.add(new Race("ERftLW", "Changeling", 0, 0, 0, 0, 0, 2, "Shapechanger, Changeling Instincts"));
        listOfRaces.add(new Race("PHB", "Dragonborn", 2, 0, 0, 0, 0, 1, "Draconic Ancestry, Breath Weapon, Damage Resistance"));
        listOfRaces.add(new Race("PHB", "Dwarf", 0, 0, 2, 0, 0, 0, "Darkvision, Dwarven Resilience, Dwarven Combat Training, Stonecunning"));
        listOfRaces.add(new Race("PHB", "Elf", 0, 2, 0, 0, 0, 0, "Darkvision, Keen Senses, Fey Ancestry, Trance"));
        listOfRaces.add(new Race("SCAG", "Feral Tiefling", 0, 2 ,0, 1, 0, 0, "Darkvision, Hellish Resistance, Infernal Legacy"));
        listOfRaces.add(new Race("VGtM", "Firbolg", 1, 0, 0, 0, 2, 0, "Firbolg Magic, Hidden Step, Powerful Build, Speech of Beast and Leaf"));
        listOfRaces.add(new Race("EEPC", "Genasi (Air)", 0, 1, 2, 0, 0, 0, "Unending Breath, Mingle with the Wind"));
        listOfRaces.add(new Race("EEPC", "Genasi (Earth)", 1, 0, 2, 0, 0, 0, "Earth Walk, Merge with Stone"));
        listOfRaces.add(new Race("EEPC", "Genasi (Fire)", 0, 0, 2, 1, 0, 0, "Darkvision(Plane of Fire), Fire Resistance, Reach to the Blaze"));
        listOfRaces.add(new Race("EEPC", "Genasi (Water)", 0, 0, 2, 0, 1, 0, "Acid Resistance, Amphibious, Swim, Call to the Wave"));
        listOfRaces.add(new Race("MToF", "Gith", 0, 0, 0, 1, 0, 0, "Githyanki or Githzerai Traits"));
        listOfRaces.add(new Race("PHB", "Gnome", 0, 0, 0, 2, 0, 0, "Darkvision, Gnome Cunning"));
        listOfRaces.add(new Race("VGtM", "Goblin", 0, 2, 1, 0, 0, 0, "Darkvision, Fury of the Small, Nimble Escape"));
        listOfRaces.add(new Race("EEPC", "Goliath", 2, 0, 1, 0, 0, 0, "Natural Athlete, Stone's Endurance, Powerful Build, Mountain Born"));
        listOfRaces.add(new Race("OGA", "Grung", 0, 2, 1, 0, 0, 0, "Arboreal Alertness, Amphibious, Poison Immunity, Poisonous Skin, Alertness, Standing Leap, Water Dependency"));
        listOfRaces.add(new Race("PHB", "Half-Elf", 0, 0, 0, 0, 0, 2, "Darkvision, Fey Ancestry, Skill Versatility"));
        listOfRaces.add(new Race("PHB", "Halfling", 0, 2, 0, 0 , 0, 0, "Lucky, Brave, Halfling Nimbleness"));
        listOfRaces.add(new Race("PHB", "Half-Orc", 2, 0, 1, 0, 0, 0, "Darkvision, Menacing, Relentless Endurance, Savage Attacks"));
        listOfRaces.add(new Race("VGtM", "Hobgoblin", 0, 0, 2, 1, 0, 0, "Darkvision, Martial Training, Saving Face"));
        listOfRaces.add(new Race("PHB", "Human", 1, 1, 1, 1, 1, 1, "Extra Language"));
        listOfRaces.add(new Race("ERftLW", "Kalashtar", 0, 0, 0, 0, 2, 1, "Dual Mind, Mental Discipline, Mind Link, Severed from Dreams"));
        listOfRaces.add(new Race("VGtM", "Kenku", 0, 2, 0, 0, 0, 0, "Expert Forging, Kenku Training, Mimicry"));
        listOfRaces.add(new Race("VGtM", "Kobold", 0, 2, 0, 0, 0, 0, "Darkvision, Pack Tactics, Sunlight Sensitivity, Grovel, Cower, and Beg"));
        listOfRaces.add(new Race("MOoT", "Leonin", 1, 0, 2, 0, 0, 0, "Darkvision, Claws, Hunter's Instincts, Daunting Roar"));
        listOfRaces.add(new Race("VGtM", "Lizardfolk", 0, 0, 2, 0, 1, 0, "Bite, Cunning Artisan, Hold Breath, Hunter's Lore, Natural Armor, Hungry Jaws"));
        listOfRaces.add(new Race("LR", "Locathah", 2, 1, 0, 0, 0, 0, "Natural Armor, Observant & Athletic, Leviathan Will, Limited Amphibiousness"));
        listOfRaces.add(new Race("GGtR", "Loxodon", 0, 0, 2, 0, 1, 0, "Powerful Build, Loxodon Serenity, Natural Armor, Trunk, Keen Smell"));
        listOfRaces.add(new Race("GGtR", "Minotaur", 2, 0, 1, 0, 0, 0, "Horns, Goring Rush, Hammering Horns, Imposing Presence"));
        listOfRaces.add(new Race("VGtM", "Orc", 2, 0, 1, 0, 0, 0, "Darkvision, Aggressive, Primal Intuition, Powerful Build"));
        listOfRaces.add(new Race("ERftLW", "Orc Of Eberron", 2, 0, 1, 0, 0, 0, "Darkvision, Aggressive, Powerful Build, Primal Intuition"));
        listOfRaces.add(new Race("EGtW", "Orc Of Exandria", 2, 0, 1, 0, 0, 0, "Darkvision, Aggressive, Powerful Build, Primal Intuition"));
        listOfRaces.add(new Race("MOoT", "Satyr", 0, 1, 0, 0, 0, 2, "Fey, Ram, Magic Resistance, Mirthful Leaps, Reveler"));
        listOfRaces.add(new Race("ERftLW", "Shifter", 0, 0, 0, 0, 0, 0, "Darkvision, Shifting"));
        listOfRaces.add(new Race("GGtR", "Simic Hybrid", 0, 0, 2, 0, 0, 0, "Darkvision, Animal Enhancement"));
        listOfRaces.add(new Race("VGtM", "Tabaxi", 0, 2, 0, 0, 0, 1, "Darkvision, Feline Agility, Cat's Claws, Cat's Talent"));
        listOfRaces.add(new Race("PHB", "Tiefling", 0, 0, 0, 1, 0, 2, "Darkvision, Hellish Resistance, Infernal Legacy"));
        listOfRaces.add(new Race("VGtM", "Triton", 1, 0, 1, 0, 0, 1,"Amphibious, Control Air and Water, Emissary of the Sea, Guardian of the Depths"));
        listOfRaces.add(new Race("TTP", "Tortle", 2, 0, 0, 0, 1, 0, "Claws, Hold Breath, Natural Armor, Shell Defense, Survival Instinct"));
        listOfRaces.add(new Race("GGtR", "Vedalken", 0, 0, 0, 2, 1, 0, "Vedalken Dispassion, Tireless Precision, Partially Amphibious"));
        listOfRaces.add(new Race("AI", "Verdan", 0, 0, 1, 0, 0, 2, "Black Blood Healing, Limited Telepathy, Persuasive, Telepathic Insight"));
        listOfRaces.add(new Race("ERftLW", "Warforged", 0, 0, 2, 0, 0, 0, "Constructed Resilience, Sentry's Rest, Integrated Protection, Specialized Design"));
        listOfRaces.add(new Race("VGtM", "Yuan-Ti Pureblood", 0, 0, 0, 1, 0, 2, "Dakvision, Innate Spellcasting, Magic Resistance, Poison Immunity"));
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String characterName = getStringFromUser(br);
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

            System.out.print("Your first roll is " + coreStats[5] + "\n" + "Your second roll is " + coreStats[4] + "\n" + "Your third roll is " +
                    coreStats[3] + "\n" + "Your fourth roll is " + coreStats[2] + "\n" + "Your fifth roll is " + coreStats[1] + "\n" +
                    "Your sixth roll is " + coreStats[0] + "\n Please prioritize your stats by entering a number \"1\" through \"6\" in the following fields.\nStrength priority: ");

            for(;;) {
                int strengthInput = 0;
                int dexterityInput = 0;
                int constitutionInput = 0;
                int intelligenceInput = 0;
                int wisdomInput = 0;
                int charismaInput = 0;
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
                                    }//end if (charismaInput...
                                }//end if (wisdomInput...
                            }//end if (intelligenceInput...
                        }//end if (constitutionInput...
                    }//end if (dexterityInput...
                }//end if (strengthInput...
                System.out.print("Priorities entered incorrectly. Try again.\nStrength priority: ");
            }//end of stat priority for loop scope.
            System.out.print("Your strength is " + theCharacter.strength + "\nYour dexterity is " + theCharacter.dexterity + "\nYour constitution is " + theCharacter.constitution +
            "\nYour intelligence is " + theCharacter.intelligence + "\nYour wisdom is " + theCharacter.wisdom +  "\nYour charisma is " + theCharacter.charisma);

            StringBuilder message = new StringBuilder("\nPlease type the corresponding number from the following races (Full support only for SRD materials): ");
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
                System.out.print("\nThat was not a number associated with a race.\nType here: ");
            }

            if (theCharacter.race != null) {
                if (theCharacter.race.name == "Half-Elf") {
                    System.out.print("\nHalf-elves get two floating stat bonuses of +1 on two stats without an existing racial bonus."
                    + "\nWhere would you like to place them?");
                    getRaceStats(theCharacter, br, 4);
                }
                if (theCharacter.race.name == "Simic Hybrid") {
                    System.out.print("\nSimic Hybrids get a floating stat bonus of +1 on any stat without an existing racial bonus."
                    +"\nSimic Hybrids start with a racial bonus of +2 Constitution.\n");
                   getRaceStats(theCharacter, br, 3);
                }
                if (theCharacter.race.name == "Warforged"){
                    System.out.print("\nWarforged get a floating stat bonus of +1 on any stat without an existing racial bonus."
                    +"\nWarforged start with a racial bonus of +2 Constitution.\n");
                   getRaceStats(theCharacter, br, 3);
                }//end floating bonus checking
                message.replace(0, message.length(), "The race " + theCharacter.race.name + " gains the following ability score bonuses.");
                if (theCharacter.race.strengthBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.strengthBonus).append(" to strength.");
                    theCharacter.strength += theCharacter.race.strengthBonus;
                }
                if (theCharacter.race.dexterityBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.dexterityBonus).append(" to dexterity.");
                    theCharacter.dexterity += theCharacter.race.dexterityBonus;
                }
                if (theCharacter.race.constitutionBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.constitutionBonus).append(" to constitution.");
                    theCharacter.constitution += theCharacter.race.constitutionBonus;
                }
                if (theCharacter.race.intelligenceBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.intelligenceBonus).append(" to intelligence.");
                    theCharacter.intelligence += theCharacter.race.intelligenceBonus;
                }
                if (theCharacter.race.wisdomBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.wisdomBonus).append(" to wisdom.");
                    theCharacter.wisdom += theCharacter.race.wisdomBonus;
                }
                if (theCharacter.race.charismaBonus != 0) {
                    message.append("\n").append("+").append(theCharacter.race.charismaBonus).append(" to charisma.");
                    theCharacter.charisma += theCharacter.race.charismaBonus;
                } 
                if (theCharacter.race.strengthBonus == 0 && theCharacter.race.dexterityBonus == 0 && theCharacter.race.constitutionBonus == 0 
                        && theCharacter.race.intelligenceBonus == 0 && theCharacter.race.wisdomBonus == 0 && theCharacter.race.charismaBonus == 0) { 
                            message.append("\n").append("No ability score bonuses found.");
                }
                System.out.print(message);
                
                System.out.println("\nYour ability score bonuses have been added to your base ability scores.");
                System.out.print("\nYour total strength is " + theCharacter.strength + "\n" + "Your total dexterity is " + theCharacter.dexterity + "\n" + "Your total constitution is " +
                theCharacter.constitution + "\n" + "Your total intelligence is " + theCharacter.intelligence + "\n" + "Your total wisdom is " + theCharacter.wisdom + "\n" +
                "Your total charisma is " + theCharacter.charisma + "\n");
                
                message.replace(0, message.length(), "\nPlease type the corresponding number from the following classes: ");
                for (int i = 0; i < listOfClasses.size(); i++) {
                    message.append("\n").append(i).append(" - ").append(listOfClasses.get(i).name);
                } 
                System.out.print(message.append("\nType here: ").toString());
                for(;;) { 
                    int userChoice = getIntFromUser(br);
                    if (userChoice > -1 && userChoice < listOfClasses.size()) {
                        theCharacter.CharacterClass = listOfClasses.get(userChoice);
                        break;
                    }
                    System.out.print("\nThat was not a number associated with a class.\nType here: ");
                } 
                System.out.print(message);
                System.out.print("\nThe class you chose was " + theCharacter.CharacterClass.name + ".");
                System.out.print("\nThis is a preview of your character sheet.\n");
                message.replace(0, message.length(),"Character name: " + theCharacter.characterName + "\nRace: " + theCharacter.race.name 
                + "\nClass: " + theCharacter.CharacterClass.name + "\n Ability Scores\nStrength: " + theCharacter.strength + "\nDexterity: " 
                + theCharacter.dexterity + "\nConstitution: " + theCharacter.constitution +"\nIntelligence: " + theCharacter.intelligence + "\nWisdom: " 
                + theCharacter.wisdom + "\nCharisma: " + theCharacter.charisma);
                System.out.print(message);
                System.out.print("\n\nDo you want to save this character sheet to a .txt file? Y/N: ");
                
                for(;;) { 
                String printResponse = getStringFromUser(br);
                if(printResponse != null) {
                        if(printResponse.equals("Y") || printResponse.equals("y")) {
                            System.out.println("Searching for characters folder...");
                            File charactersFolder = new File("./characters/");
                            if (charactersFolder.exists() == true) {
                                System.out.print("Characters folder found, creating file.\n");
                                printCharacter(message, theCharacter.characterName);
                                    break;
                                } 
                            if (charactersFolder.exists() == false) {
                                System.out.println("Characters folder not found. Creating characters folder...");
                                charactersFolder.mkdir();
                                System.out.println("Characters folder created.");
                                printCharacter(message, theCharacter.characterName);
                                break;
                            }
                            System.out.print("You entered " + printResponse + ". That is an invalid command. Do you want to print this character sheet to a .txt file? Y/N: "); 
                        }//end if(printResponse.equals("Y"...
                        if (printResponse.equals("N") || printResponse.equals("n")) {
                            System.out.println("Thank you for using my character generator. Your character has not been saved.");
                            break;
                        }
                    }//end if(printResponse != null)
                }//end of loop asking whether or not to print.
                for(;;) {
                    System.out.print("\nPress enter to exit.");
                    String input = getStringFromUser(br);
                    if(input != null) {
                        break;
                    } else {
                        System.out.print("\nAn unexpected error has occured.\nOn Windows, press ctrl + C to terminate this console."
                        + "\nIf you have this program, you probably know the developer. Please report this error to him.");
                    }
                }//end of continuation loop. Program should terminate here.
            } //end if (theCharacter.race != null)
        } //end if (characterName != null)
    }
}
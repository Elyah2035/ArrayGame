import java.util.Scanner;

public class Game {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";



    static int ysize = 20;
    static int xsize = 60;



    static char[][] map = new char[ysize][xsize];


    static void teleporter(){
        map[10][10] = '□';
        map[10][50] = '□';

        if(map[characterPossitiionX][characterPossitiionY]== '□'){
            if(characterPossitiionX == 10 && characterPossitiionY == 50){
                characterPossitiionX = 10;
                characterPossitiionY = 10;
            }
            else{
                characterPossitiionX = 10;
                characterPossitiionY = 50;
            }



        }


    }
    static void map(){

        //make a NPC
        map[10][5] = 'M';

        map[10][10] = '□';
        map[10][50] = '□';


        //make random cookies everywhere




        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++)
                if(map[i][j] == '\u0000') {
                    map[i][j] = ' ';
                }
        }

        for (int i = 0; i < map.length; i++) {
            map[i][0] = '┃';
            map[i][map[i].length - 1] = '┃';
        }




        //last line of the map all '#'
        for (int i = 0; i < map[map.length - 1].length; i++) {
            map[map.length - 1][i] = '─';
        }
        //first line of the map all '#'
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = '─';
        }




        //printing out the map
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++)
                if (map[i][j]=='c'){

                    System.out.printf(ANSI_YELLOW + "%3c" + ANSI_RESET, map[i][j]);
                }
                else if(map[i][j]=='M'){

                    System.out.printf(ANSI_BLUE + "%3c" + ANSI_RESET, map[i][j]);
                }
                else if(map[i][j]=='@'){

                    System.out.printf(ANSI_RED + "%3c" + ANSI_RESET, map[i][j]);
                }
                else if(map[i][j]=='□'){

                    System.out.printf(ANSI_GREEN + "%3c" + ANSI_RESET, map[i][j]);
                }


                else {
                    System.out.printf("%3c", map[i][j]);
                }
            System.out.println();
        }




    }
    static int backpackxsize = 20;
    static int backpackysize = 20;

    static char[][] backpack = new char[backpackysize][backpackxsize];
    /*static void backBack(){

        System.out.println("Backpack");
        System.out.println("Cookies: " + cookieCounter);
        System.out.println("Coins: " + coinCounter);





        move();

    }*/

    static  int cookieCounter = 0;
    static int coinCounter = 0;

    static int characterPossitiionX = 1;
    static int characterPossitiionY = 1;

    static void character(){
        map[characterPossitiionX][characterPossitiionY] = '@';
    }
    static Scanner scanner = new Scanner(System.in);

    static String movement;
    static void move(){


        System.out.print("Where to go? ");
        movement = scanner.nextLine();
        //  scanner.close();

        jump();
        if (movement.equals("w")) {

            map[characterPossitiionX][characterPossitiionY] = ' ';

            characterPossitiionX--;
            checkIfOK();
            if(map[characterPossitiionX][characterPossitiionY] == '─' || map[characterPossitiionX][characterPossitiionY] == '┃'){
                characterPossitiionX++;
            }
            if (map[characterPossitiionX][characterPossitiionY] == 'M' ){
                characterPossitiionX++;
                NPCInteraction();
            }


        }
        if (movement.equals("s")) {

            map[characterPossitiionX][characterPossitiionY] = ' ';
            characterPossitiionX++;
            checkIfOK();
            if(map[characterPossitiionX][characterPossitiionY] == '─' || map[characterPossitiionX][characterPossitiionY] == '┃'){
                characterPossitiionX--;
            }
            if (map[characterPossitiionX][characterPossitiionY] == 'M' ){
                characterPossitiionX--;
                NPCInteraction();
            }

        }
        if (movement.equals("a")) {

            map[characterPossitiionX][characterPossitiionY] = ' ';
            characterPossitiionY--;
            checkIfOK();
            if(map[characterPossitiionX][characterPossitiionY] == '─' || map[characterPossitiionX][characterPossitiionY] == '┃'){
                characterPossitiionY++;
            }
            if (map[characterPossitiionX][characterPossitiionY] == 'M' ){
                characterPossitiionY++;
                NPCInteraction();
            }

        }
        if (movement.equals("d")) {

            map[characterPossitiionX][characterPossitiionY] = ' ';
            characterPossitiionY++;
            checkIfOK();
            if(map[characterPossitiionX][characterPossitiionY] == '─' || map[characterPossitiionX][characterPossitiionY] == '┃'){
                characterPossitiionY--;
            }
            if (map[characterPossitiionX][characterPossitiionY] == 'M' ){
                characterPossitiionY--;
                NPCInteraction();

            }
        }
        if (movement.equals("q")) {
            System.exit(0);
        }
        if (movement.equals("e")) {
            backBack();

        }
        if (movement.equals("h")) {
            System.out.println("w = up, s = down, a = left, d = right, q = quit, e = Backpack, h = help");
            move();
        }
        if (movement.equals("c")) {
            System.out.println("You have found a cookie!");
            cookieCounter= cookieCounter + 999999999;
            move();
        }
        if (movement.equals("p")) {
            System.out.println("You have found a coin!");
            coinCounter++;
            move();
        }








        character();
        for (int i =0;i<100;i++) {
            System.out.println();
        }
    }


    static void jump() {


        if (movement.equals("ww")) {

            map[characterPossitiionX][characterPossitiionY] = ' ';
            checkIfOK();
            characterPossitiionX=characterPossitiionX-2;

            if (map[characterPossitiionX][characterPossitiionY] == '─' || map[characterPossitiionX][characterPossitiionY] == '┃') {
                characterPossitiionX=characterPossitiionX+2;
            }
            if (map[characterPossitiionX][characterPossitiionY] == 'M') {
                characterPossitiionX=characterPossitiionX+2;
                NPCInteraction();
            }


        }
        if (movement.equals("ss")) {

            map[characterPossitiionX][characterPossitiionY] = ' ';
            checkIfOK();
            characterPossitiionX=characterPossitiionX+2;

            if (map[characterPossitiionX][characterPossitiionY] == '─' || map[characterPossitiionX][characterPossitiionY] == '┃') {
                characterPossitiionX=characterPossitiionX-2;
            }
            if (map[characterPossitiionX][characterPossitiionY] == 'M') {
                characterPossitiionX=characterPossitiionX-2;
                NPCInteraction();
            }

        }
        if (movement.equals("aa")) {

            map[characterPossitiionX][characterPossitiionY] = ' ';
            checkIfOK();
            characterPossitiionY=characterPossitiionY-2;

            if (map[characterPossitiionX][characterPossitiionY] == '─' || map[characterPossitiionX][characterPossitiionY] == '┃') {
                characterPossitiionY=characterPossitiionY+2;
            }
            if (map[characterPossitiionX][characterPossitiionY] == 'M') {
                characterPossitiionY=characterPossitiionY+2;
                NPCInteraction();
            }

        }
        if (movement.equals("dd")) {

            map[characterPossitiionX][characterPossitiionY] = ' ';
            characterPossitiionY=characterPossitiionY+2;
            checkIfOK();
            if (map[characterPossitiionX][characterPossitiionY] == '─' || map[characterPossitiionX][characterPossitiionY] == '┃') {
                characterPossitiionY=characterPossitiionY-2;
            }
            if (map[characterPossitiionX][characterPossitiionY] == 'M') {
                characterPossitiionY=characterPossitiionY-2;
                NPCInteraction();
            }


        }
    }



    static void checkIfOK() {
        //cheack if coin
        if (map[characterPossitiionX][characterPossitiionY] == 'c') {
            coinCounter++;
        }
        //check if dead
        if (map[characterPossitiionX][characterPossitiionY]=='■'){
            System.out.println("You have died!");
            System.exit(0);
        }
        teleporter();


        //check if out of border
        if (characterPossitiionX <=0) {
            characterPossitiionX = 1;
        }
        if (characterPossitiionY <=0) {
            characterPossitiionY = 1;
        }
        if (characterPossitiionX >= 20) {
            characterPossitiionX = 19;
        }
        if (characterPossitiionY >= 60) {
            characterPossitiionY = 59;
        }
    }

    static void NPCInteraction () {
        //map[10][44] = 'M';

        System.out.println("Hello wanderer I am the cookie monster!");
        System.out.println("I will give you a cookie if you give me 5 coins!");
        System.out.println("Do you want to trade? (y/n)");
        String trade = scanner.nextLine();
        if (trade.equals("y")) {
            if (coinCounter >= 5) {
                System.out.println("You have traded 5 coin for 1 cookie!");
                coinCounter = coinCounter - 5;
                cookieCounter++;
            } else {
                System.out.println("You don't have enough coins!");

            }
        } else {
            System.out.println("Ok, bye!");

        }
        map();
    }





    static void backBack() {


        //make it that it is written in printf and only shows the ones that are not 0
        if (coinCounter > 0) {
            System.out.printf("You have %d coins\n", coinCounter);
        }
        if (cookieCounter > 0) {
            System.out.printf("You have %d cookies\n", cookieCounter);
        }
        if (keyCounter > 0) {
            System.out.printf("You have %d keys\n", keyCounter);
        }
        if (swordCounter > 0) {
            System.out.printf("You have %d swords\n", swordCounter);
        }
        if (shieldCounter > 0) {
            System.out.printf("You have %d shields\n", shieldCounter);
        }
        if (potionCounter > 0) {
            System.out.printf("You have %d potions\n", potionCounter);
        }
        if (armorCounter > 0) {
            System.out.printf("You have %d armor\n", armorCounter);
        }
        if (bowCounter > 0) {
            System.out.printf("You have %d bows\n", bowCounter);
        }
        if (arrowCounter > 0) {
            System.out.printf("You have %d arrows\n", arrowCounter);
        }
        if (bombCounter > 0) {
            System.out.printf("You have %d bombs\n", bombCounter);
        }
        if (gunCounter > 0) {
            System.out.printf("You have %d guns\n", gunCounter);
        }
        if (bulletCounter > 0) {
            System.out.printf("You have %d bullets\n", bulletCounter);
        }
        if (grenadeCounter > 0) {
            System.out.printf("You have %d grenades\n", grenadeCounter);
        }
        if (medkitCounter > 0) {
            System.out.printf("You have %d medkits\n", medkitCounter);
        }
        if (foodCounter > 0) {
            System.out.printf("You have %d food\n", foodCounter);
        }
        if (waterCounter > 0) {
            System.out.printf("You have %d water\n", waterCounter);
        }
        if (woodCounter > 0) {
            System.out.printf("You have %d wood\n", woodCounter);
        }
        if (stoneCounter > 0) {
            System.out.printf("You have %d stone\n", stoneCounter);
        }
        if (ironCounter > 0) {
            System.out.printf("You have %d iron\n", ironCounter);
        }
        if (goldCounter > 0) {
            System.out.printf("You have %d gold\n", goldCounter);
        }
        if (diamondCounter > 0) {
            System.out.printf("You have %d diamond\n", diamondCounter);
        }
        if (emeraldCounter > 0) {
            System.out.printf("You have %d emerald\n", emeraldCounter);
        }
        if (rubyCounter > 0) {
            System.out.printf("You have %d ruby\n", rubyCounter);
        }
        if (sapphireCounter > 0) {
            System.out.printf("You have %d sapphire\n", sapphireCounter);
        }
        if (amethystCounter > 0) {
            System.out.printf("You have %d amethyst\n", amethystCounter);
        }
        if (topazCounter > 0) {
            System.out.printf("You have %d topaz\n", topazCounter);
        }
        if (opalCounter > 0) {
            System.out.printf("You have %d opal\n", opalCounter);
        }
        if (quartzCounter > 0) {
            System.out.printf("You have %d quartz\n", quartzCounter);
        }
        if (copperCounter > 0) {
            System.out.printf("You have %d copper\n", copperCounter);
        }
        if (tinCounter > 0) {
            System.out.printf("You have %d tin\n", tinCounter);
        }
        if (bronzeCounter > 0) {
            System.out.printf("You have %d bronze\n", bronzeCounter);
        }
        if (silverCounter > 0) {
            System.out.printf("You have %d silver\n", silverCounter);
        }
        if (goldCounter > 0) {
            System.out.printf("You have %d gold\n", goldCounter);
        }
        if (diamondCounter > 0) {
            System.out.printf("You have %d diamond\n", diamondCounter);
        }
        if (emeraldCounter > 0) {
            System.out.printf("You have %d emerald\n", emeraldCounter);
        }
        if (rubyCounter > 0) {
            System.out.printf("You have %d ruby\n", rubyCounter);
        }
        if (sapphireCounter > 0) {
            System.out.printf("You have %d sapphire\n", sapphireCounter);
        }
        if (amethystCounter > 0) {
            System.out.printf("You have %d amethyst\n", amethystCounter);
        }
        move();
    }
    static    int keyCounter, swordCounter, shieldCounter, potionCounter, armorCounter, bowCounter, arrowCounter, bombCounter, gunCounter, bulletCounter, grenadeCounter, medkitCounter, foodCounter, waterCounter, woodCounter, stoneCounter, ironCounter, goldCounter, diamondCounter, emeraldCounter, rubyCounter, sapphireCounter, amethystCounter, topazCounter, opalCounter, quartzCounter, copperCounter, tinCounter, bronzeCounter, silverCounter;



    public static void main(String[] args) {
        character();

//coins spawning
        for(int i = 0; i < 100; i++){
            int randomx = (int)(Math.random() * xsize);
            int randomy = (int)(Math.random() * ysize);
            map[randomy][randomx] = 'c';
        }
//anemys spawning

        for(int i = 0; i < 500; i++){
            int randomx = (int)(Math.random() * xsize);
            int randomy = (int)(Math.random() * ysize);
            map[randomy][randomx] = '■';
        }


        while(true) {



            character();


            map();

            move();

        }
    }

}

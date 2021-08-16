
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

/*This program is for reflectometer to measure the ABV*/
public class ABVcalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static double OG = 0;
    private static double FG = 0;
    private static Formatter x;
    private static Date d = new Date();
    private static String date= d.getMonth()+ 1+ "month&"+ d.getDate()+"day&"+ d.getHours()+"Hours&"+d.getMinutes()+"Time"+d.getSeconds()+"second";
    private static double couFaGuoGuy=0;
    private static  double enRenGuy = 0;
    private static double thirdGuy= 0;
    private static String fileName="";
    private static double brixForOG= 0;

    public static void main(String[] args) {


        resultOfOriginalGravity();
        resultOfFinalGravity();
        calculateABV();
         productType();
       creatFileAndAddOGFGABVvalue();

    }

    public static void resultOfOriginalGravity(){
        double OGOG= 0;
        System.out.print("input your Original Brix value :  ");
         brixForOG = scanner.nextDouble();
        OGOG = (brixForOG/(258.6-((brixForOG/258.2)*227.1)))+ 1.0;
        OG+= OGOG;
        System.out.print( "\tOG's value: "+ OG);


    }

    public static void resultOfFinalGravity(){
        double FGFG= 0;
        System.out.print("\ninput your Final Brix value: ");
        double Brix = scanner.nextDouble();
        FGFG = (Brix/(258.6-((Brix/258.2)*227.1)))+ 1.0;
        FG+=FGFG;
        System.out.println("\tFG's value: " + FG);


    }

    public static void calculateABV(){
        double couFaGuoGuycouFaGuoGuy=0;
        couFaGuoGuy= (((OG-FG)/7.5)*1000)+0.5;
        couFaGuoGuy+=couFaGuoGuycouFaGuoGuy;
        System.out.println("\ncouFaGuoGuy's ABV: "+ couFaGuoGuy +"%");
        double enRenGuyenRenGuy=0;
         enRenGuy= (OG-FG)*131.25;
        enRenGuy+= enRenGuyenRenGuy;
        System.out.println("enRenGuy's ABV: "+ enRenGuy+ "%");
        double thirdGuythirdGuy= 0;
         thirdGuy= (76.08*(OG-FG)/(1.775-OG))*(FG/0.794);
        thirdGuy+= thirdGuythirdGuy;
        System.out.println("thirdGuy's ABV: "+ thirdGuy+ "%");

    }
    public static void creatFileAndAddOGFGABVvalue(){
        //创建file
        try {
            x = new Formatter("D:\\Project\\RecordDataForRefermentation\\ "+ fileName+ date+ ".txt");

            System.out.println("you created a txt file;");
        } catch (Exception e) {
            System.out.println("you got an error, when you create txt file;");
        }
        /*记录OG值到文件*/
        x.format("%s\t\n%s\t\n", d+ "      your Original Gravity is:       "+ OG," Brix value of Original Gravity is : "+ brixForOG);
        System.out.println("记录成功");

        /*记录FG值到文件*/
        x.format("%s\t\n",date + "      your Final Gravity is:      "+ FG);
        System.out.println("记录成功");

        /*记录ABV值到文件*/
        x.format("%s\t\n","     couFaGuoGuy's ABV: "+ couFaGuoGuy +"%");
        x.format("%s\t\n","     enRenGuy's ABV: "+ enRenGuy+ "%");
        x.format("%s\t\n","     thirdGuy's ABV: "+ thirdGuy+ "%");
        System.out.println("记录成功");
        x.close();
    }
    public static void productType(){
        System.out.print("\ninput product name that you want to use for file name:");
         fileName= scanner.next();
    }

}

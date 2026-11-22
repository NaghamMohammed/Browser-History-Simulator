import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //نستخدمها لاستقبال ادخال المستخدم من لوحة المفاتيح

        BrowserHistory browser = new BrowserHistory(); //انشنا اوبجكت من ملاس براوزر هيستوري  بمجرد انشاءه سيعمل الكونستركتر الخاص به وسيكون الموقع الحالي جوجل 

        int choice = 0;
        // اخترنا استخدام وايل لووب لاننا نريد ان تستمر القائمة يالظهور بعد كل عملية ولا ينتهي البرنامج الا عندما يختار المستخدم رقم 8
        while (choice != 8) { // حلقة تكرار مستمرة حتى يختار المستخدم الخروج من البرنامج

            System.out.println("\n===== Browser History Simulator =====");
            System.out.println("1. Visit a New Website");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Display Browsing History");
            System.out.println("5. Count Visited Websites");
            System.out.println("6. Add Bookmark");
            System.out.println("7. Display Bookmarks");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            String menuInput = input.nextLine();  //

            try { // محاولة تحويل إدخال المستخدم إلى عدد صحيح
                choice = Integer.parseInt(menuInput); // تحويل إدخال المستخدم إلى عدد صحيح

                // كاتش لمعالجة 
            } catch (NumberFormatException e) { // إذا كان الإدخال غير صالح (ليس عددًا صحيحًا) سيتم التقاط الاستثناء هنا
                System.out.println("Invalid input. Please enter a number.");
                continue; // العودة إلى بداية الحلقة لطلب إدخال جديد من المستخدم
            }

            switch (choice) { // تحدد العملية التي يريد المستخدم تنفيذها بناءً على اختياره

                case 1:
                    System.out.print("Enter website URL: "); // طلب من المستخدم إدخال رابط الموقع
                    String url = input.nextLine(); // قراءة الرابط الذي أدخله المستخدم
                    browser.visitWebsite(url); // استدعاء ميثود زيارة الموقع الجديد وتمرير الرابط الذي أدخله المستخدم
                    break;

                case 2:
                    browser.goBack();
                    break;

                case 3:
                    browser.goForward();
                    break;

                case 4:
                    browser.displayHistory();
                    break;

                case 5: // استدعاء ميثود عد المواقع التي تم زيارتها
                    System.out.println("Total visited websites: " + browser.countHistory() ); // طباعة عدد المواقع التي تم زيارتها
                    break;

                case 6:
                    browser.addBookmark(); // استدعاء ميثود اضافة الموقع الحالي الى المفضلة
                    break;

                case 7:
                    browser.displayBookmarks(); // استدعاء ميثود عرض المفضلة
                    break;

                case 8:
                    System.out.println("Exiting Browser History Simulator...");
                    break;

                default:
                    System.out.println("Invalid choice. Choose from 1 to 8.");
            }
        }

        input.close(); // إغلاق كائن Scanner بعد الانتهاء من استخدامه
    }
}

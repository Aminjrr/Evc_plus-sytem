import java.util.Scanner;

public class Main {
    // Constants
    public static final int USER_PIN = 4321;
    public static final int ACCOUNT_NUMBER = 9876543;
    public static final int BUSINESS_ID = 7890;
    public static final long TRANSACTION_ID = 217353733L;
    public static final int WITHDRAWAL_CODE = 1234;
    public static final int BANK_PIN = 7890;
    public static final int OLD_BANK_PIN = 2200;
    public static final int OTP_CODE = 5;
    public static final int BILL_REFERENCE = 100;

    // Balances
    public static int mobileBalance = 750;
    public static int bankAccountBalance = 4500;

    public static Scanner inputReader = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeScreen();
    }

    public static void displayWelcomeScreen() {
        System.out.print("Geli shortcodeka: ");
        String userInput = inputReader.nextLine();

        if (!userInput.equals("*770#")) {
            System.out.println("Shortcode-ka aad garaacday ma ahan mid jira");
            return;
        }

        authenticateUser();
    }

    public static void authenticateUser() {
        System.out.println("-EVCPLUS-\nFadlan geli PIN-kaaga (Enter PIN): ");
        int enteredPin = inputReader.nextInt();

        if (enteredPin != USER_PIN) {
            System.out.println("PIN-kaagu waa qalad.");
            return;
        }

        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("EVCPlus\n" +
                "1. Itus Haraaga\n" +
                "2. Kaarka hadalka\n" +
                "3. Bixi Biil\n" +
                "4. U wareeji EVCPlus\n" +
                "5. Warbixin Kooban\n" +
                "6. Salaam Bank\n" +
                "7. Maareynta\n" +
                "8. TAAJ\n" +
                "9. Bill Payment\n");

        int selectedOption = inputReader.nextInt();
        if (selectedOption < 1 || selectedOption > 9) {
            System.out.println("Fadlan dooro number sax ah ");
            return;
        }

        switch (selectedOption) {
            case 1:
                checkBalance();
                break;
            case 2:
                airtimeServices();
                break;
            case 3:
                billPayment();
                break;
            case 4:
                transferToEVCPlus();
                break;
            case 5:
                miniStatement();
                break;
            case 6:
                salaamBank();
                break;
            case 7:
                management();
                break;
            case 8:
                taajServices();
                break;
            case 9:
                billPaymentOption();
                break;
        }
    }

    public static void checkBalance() {
        System.out.println("<-EVCPlus-> Haraagaagu waa $" + mobileBalance);
    }

    public static void airtimeServices() {
        System.out.println("Kaarka Hadalka:\n" +
                "1. Ku Shubo Airtime\n" +
                "2. Ugu Shub Airtime\n" +
                "3. MIFI Packages\n" +
                "4. Ku shubo Internet\n" +
                "5. Ugu shub qof kale (MMT)\n");
        int airtimeChoice = inputReader.nextInt();

        if (airtimeChoice < 1 || airtimeChoice > 5) {
            System.out.println("Fadlan dooro number sax ah ");
            return;
        }

        switch (airtimeChoice) {
            case 1:
                rechargeAirtime();
                break;
            case 2:
                transferAirtime();
                break;
            case 3:
                mifiPackages();
                break;
            case 4:
                internetPackages();
                break;
            case 5:
                transferToOther();
                break;
        }
    }

    public static void rechargeAirtime() {
        System.out.println("Fadlan geli lacagta: ");
        int rechargeAmount = inputReader.nextInt();
        if (rechargeAmount > 0 && rechargeAmount <= mobileBalance) {
            System.out.println("Ma hubtaa inaad $" + rechargeAmount + " ku shubto adiga?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmation = inputReader.nextInt();
            if (confirmation == 1) {
                mobileBalance -= rechargeAmount;
                System.out.println("Waxaad ku shubtay $" + rechargeAmount + " Haraagaau Waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void transferAirtime() {
        System.out.println("Fadlan Geli Mobile-ka: ");
        int recipientNumber = inputReader.nextInt();
        System.out.println("Fadlan geli lacagta: ");
        int transferAmount = inputReader.nextInt();

        if (transferAmount > 0 && transferAmount <= mobileBalance) {
            System.out.println("Ma hubtaa inaad $" + transferAmount + " ugu shubtid " + recipientNumber + "?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmTransfer = inputReader.nextInt();
            if (confirmTransfer == 1) {
                mobileBalance -= transferAmount;
                System.out.println("Waxaad $" + transferAmount + " ugu shubtay " + recipientNumber
                        + " Haraagaagu Waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void mifiPackages() {
        System.out.println("EvcPlus\n1. Ku Shubo Data-da MIFI ");
        int mifiOption = inputReader.nextInt();
        if (mifiOption != 1) {
            System.out.println("Fadlan dooro number sax ah ");
            return;
        }

        int selectedBundle = 0;
        while (selectedBundle < 1 || selectedBundle > 3) {
            System.out.println("- Internet Bundle Recharge:\n" +
                    "1. Isbuucle(Weekly)\n" +
                    "2. Maalinle(Daily)\n" +
                    "3. Bille (MiFi)");
            selectedBundle = inputReader.nextInt();
        }

        switch (selectedBundle) {
            case 1:
                weeklyMifiBundle();
                break;
            case 2:
                dailyMifiBundle();
                break;
            case 3:
                monthlyMifiBundle();
                break;
        }
    }

    public static void weeklyMifiBundle() {
        int weeklyChoice = 0;
        while (weeklyChoice < 1 || weeklyChoice > 2) {
            System.out.println("Fadlan dooro bundle ka:\n" +
                    "1.$5 = 10 GB\n" +
                    "2.$10 = 25 GB");
            weeklyChoice = inputReader.nextInt();
        }

        System.out.print("Fadlan Gali MIFI user: ");
        int mifiUser = inputReader.nextInt();

        if (weeklyChoice == 1) {
            processMifiPurchase(mifiUser, 5, "10 GB");
        } else if (weeklyChoice == 2) {
            processMifiPurchase(mifiUser, 10, "25 GB");
        }
    }

    public static void dailyMifiBundle() {
        int dailyChoice = 0;
        while (dailyChoice < 1 || dailyChoice > 2) {
            System.out.println("Fadlan dooro bundle ka:\n " +
                    "1. $1 = 2 GB\n " +
                    "2. $2 = 5 GB");
            dailyChoice = inputReader.nextInt();
        }

        System.out.print("Fadlan Gali MIFI user: ");
        int dailyUser = inputReader.nextInt();

        if (dailyChoice == 1) {
            processMifiPurchase(dailyUser, 1, "2 GB");
        } else if (dailyChoice == 2) {
            processMifiPurchase(dailyUser, 2, "5 GB");
        }
    }

    public static void monthlyMifiBundle() {
        int mifiPlan = 0;
        while (mifiPlan < 1 || mifiPlan > 4) {
            System.out.println("Fadlan dooro bundle ka:\n" +
                    "1. $20 = 40 GB\n" +
                    "2. $40 = 85 GB\n" +
                    "3. $60 = 150 GB\n" +
                    "4. $25 = Monthly Unlimit");
            mifiPlan = inputReader.nextInt();
        }

        System.out.print("Fadlan Gali MIFI user: ");
        int mifiPlanUser = inputReader.nextInt();

        switch (mifiPlan) {
            case 1:
                processMifiPurchase(mifiPlanUser, 20, "40 GB");
                break;
            case 2:
                processMifiPurchase(mifiPlanUser, 40, "85 GB");
                break;
            case 3:
                processMifiPurchase(mifiPlanUser, 60, "150 GB");
                break;
            case 4:
                processMifiPurchase(mifiPlanUser, 25, "Monthly Unlimited");
                break;
        }
    }

    public static void processMifiPurchase(int user, int amount, String packageDesc) {
        if (amount <= mobileBalance) {
            System.out.println("Ma hubtaa inaad $" + amount + " ugu shubtid " + user + "?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmPurchase = inputReader.nextInt();
            if (confirmPurchase == 1) {
                mobileBalance -= amount;
                System.out.println("Waxaad $" + amount + " ugu shubtay " + user +
                        " (" + packageDesc + ") Haraagaau Waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid!.");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void internetPackages() {
        int internetOption = 0;
        while (internetOption < 1 || internetOption > 5) {
            System.out.println("Fadlan dooro number-ka ku shubeyso\n" +
                    "1. Isbuucle(Weekly)\n" +
                    "2. TIME BASED PACKAGES\n" +
                    "3. DATA\n" +
                    "4. Maalinle(Daily)\n" +
                    "5. Bille (MiFi)");
            internetOption = inputReader.nextInt();
        }

        System.out.println("Fadlan Geli lacagta: ");
        int internetAmount = inputReader.nextInt();
        if (internetAmount <= mobileBalance) {
            System.out.println("Ma hubtaa inaad $" + internetAmount + " ku shubatida?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmInternet = inputReader.nextInt();
            if (confirmInternet == 1) {
                mobileBalance -= internetAmount;
                System.out.println("Waxaad ku shubtay $" + internetAmount + " " +
                        " Haraagaagu Waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid!.");
            }
        } else {
            System.out.println("Haraaga xisaabtaadu kuguma filna,");
        }
    }

    public static void transferToOther() {
        System.out.println("Fadlan Geli Mobile-ka");
        int mobileTransfer = inputReader.nextInt();
        System.out.println("Fadlan geli lacagta: ");
        int transferValue = inputReader.nextInt();
        if (transferValue <= mobileBalance) {
            System.out.println("Ma hubtaa inaad $" + transferValue + " ugu shubtid Tell No  " + mobileTransfer + "?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmTransfer = inputReader.nextInt();
            if (confirmTransfer == 1) {
                mobileBalance -= transferValue;
                System.out.println("Waxaad $" + transferValue + " ugu shubtay Tell no  " + mobileTransfer + " " +
                        "Haraagaagu Waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void billPayment() {
        System.out.println("Bixi Biil\n" +
                "1. Post Paid\n" +
                "2. Ku libso");
        int billOption = inputReader.nextInt();
        if (billOption < 1 || billOption > 2) {
            System.out.println("Fadlan dooro number sax ah");
            return;
        }

        if (billOption == 1) {
            postPaidBill();
        } else if (billOption == 2) {
            kuLibsoBill();
        }
    }

    public static void postPaidBill() {
        System.out.println("Post Paid\n" +
                "1. Ogow Biilka\n" +
                "2. Bixi Biil\n" +
                "3. Ka Bixi Biil");
        int postPaidChoice = inputReader.nextInt();
        if (postPaidChoice < 1 || postPaidChoice > 3) {
            System.out.println("Fadlan dooro number sax ah");
            return;
        }

        switch (postPaidChoice) {
            case 1:
                System.out.println("Error");
                break;
            case 2:
                payBillSelf();
                break;
            case 3:
                payBillOther();
                break;
        }
    }

    public static void payBillSelf() {
        System.out.println("Fadlan Geli Lacagta: ");
        int billAmount = inputReader.nextInt();
        if (billAmount <= mobileBalance) {
            System.out.println("Ma Hubtaa inaad bixisid bill lacagtiisu tahay " + billAmount + "$?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmBill = inputReader.nextInt();
            if (confirmBill == 1) {
                mobileBalance -= billAmount;
                System.out.println("Waxaad bixisay bill lacagtiisu tahay " + billAmount + "$" +
                        " Haraagaau Waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid!.");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void payBillOther() {
        System.out.println("Fadlan Geli Mobile-ka");
        int billMobile = inputReader.nextInt();
        System.out.println("Fadlan Geli Lacagta: ");
        int billPayment = inputReader.nextInt();
        if (billPayment <= mobileBalance) {
            System.out.println("Ma Hubtaa inaad bixisid bill lacagtiisu tahay:  " + billPayment + "$" + " " +
                    "oo laga rabo tel no " + " " + billMobile + "?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmPayment = inputReader.nextInt();
            if (confirmPayment == 1) {
                mobileBalance -= billPayment;
                System.out.println("Waxaad bixisay bill lacagtiisu tahay: " + billPayment + "$" + " " +
                        "Una dirtay tel no " + billMobile + " " + "Haraagaagu Waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid!.");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void kuLibsoBill() {
        int enteredBusinessId = 0;

        for (int attempts = 0; attempts < 5 && enteredBusinessId != BUSINESS_ID; attempts++) {
            System.out.println("Fadlan Geli aqoonsiga ganacsiga: ");
            enteredBusinessId = inputReader.nextInt();
            if (enteredBusinessId != BUSINESS_ID) {
                System.out.println("Invalid input format(dataType)");
            }
            if (attempts == 4 && enteredBusinessId != BUSINESS_ID) {
                System.out.println("waxaad gaartay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        System.out.println("Fadlan soo geli lacagta: ");
        int purchaseAmount = inputReader.nextInt();
        if (purchaseAmount <= mobileBalance) {
            System.out.println("Mahubtaa inaad ku iibsato " + "$" + purchaseAmount + "?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmPurchase = inputReader.nextInt();
            if (confirmPurchase == 1) {
                mobileBalance -= purchaseAmount;
                System.out.println("Waad ku iibsatay" + " Lacag Dhan $" + purchaseAmount + " " +
                        "Haraagaagu waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid!.");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void transferToEVCPlus() {
        System.out.println("Fadlan Geli Mobile-ka");
        int transferNumber = inputReader.nextInt();
        System.out.println("Fadlan Geli Lacagta: ");
        int transferValue = inputReader.nextInt();
        if (transferValue <= mobileBalance) {
            System.out.println("Ma Hubtaa inaad " + "$" + transferValue + " " +
                    "U wareejisid " + transferNumber + "?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmTransfer = inputReader.nextInt();
            if (confirmTransfer == 1) {
                mobileBalance -= transferValue;
                System.out.println("Waxaad " + "$" + transferValue + " " +
                        "U wareejisay tel no " + transferNumber + " Haraagaagu waa $" + mobileBalance);
            } else {
                System.out.println("Mahadsanid!.");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void miniStatement() {
        System.out.println("Warbixin Kooban\n" +
                "1. Last Action\n" +
                "2. Wareejintii u dambsay\n" +
                "3. libsashadii u dambeysay\n" +
                "4. Last 3 Actions\n" +
                "5. Email Me My ACtivity");
        int miniStatement = inputReader.nextInt();
        if (miniStatement < 1 || miniStatement > 5) {
            System.out.println("Fadlan dooro number sax ah ");
            return;
        }

        switch (miniStatement) {
            case 1:
                System.out.println("$.25 Ayaad u wareejisay 252615317741, Taariikh: 26/10/25 20:23:45");
                break;
            case 2:
                transferHistory();
                break;
            case 3:
                businessPurchaseHistory();
                break;
            case 4:
                lastThreeActions();
                break;
            case 5:
                emailActivity();
                break;
        }
    }

    public static void transferHistory() {
        System.out.println("Wareejintii u dambeysay:");
        System.out.println("1.U dirtay");
        System.out.println("2.kaheshay");
        int transferHistory = inputReader.nextInt();
        if (transferHistory == 1) {
            System.out.println("$.25 Ayaad u wareejisay 252614937336, Taariikh: 26/10/25 20:23:45");
        } else if (transferHistory == 2) {
            System.out.println("operation succeeded No Transactions to display!");
        }
    }

    public static void businessPurchaseHistory() {
        int businessAuth = 0;
        for (int attempts = 0; attempts < 5 && businessAuth != BUSINESS_ID; attempts++) {
            System.out.println("Fadlan Geli aqoonsiga ganacsiga: ");
            businessAuth = inputReader.nextInt();
            if (businessAuth != BUSINESS_ID) {
                System.out.println("Invalid input format(dataType)");
            }
            if (attempts == 4 && businessAuth != BUSINESS_ID) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        System.out.println("Fadlan soo geli lacagta: ");
        int purchaseAmount = inputReader.nextInt();
        if (purchaseAmount <= mobileBalance) {
            System.out.println("Mahubtaa inaad ku iibsato " + "$" + purchaseAmount + "?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmPurchase = inputReader.nextInt();
            if (confirmPurchase == 1) {
                mobileBalance -= purchaseAmount;
                System.out.println("Waad ku iibsatay" + " Lacag Dhan $" + purchaseAmount + " " +
                        "Haraagaagu waa $" + mobileBalance);
            } else if (confirmPurchase == 2) {
                System.out.println("Mahadsanid!.");
            } else {
                System.out.println("Mahadsanid!.");
            }
        } else {
            System.out.println("Haraaga xisaabtaada Kuguma filna");
        }
    }

    public static void lastThreeActions() {
        System.out.println("Last 3 Actions:");
        System.out.println("1. $.25 -> 252617353733, Taariikh: 26/10/25 10:23:32");
        System.out.println("2. $.10 -> 252615317741, Taariikh: 25/10/25 24:15:40 ");
        System.out.println("3. $.5 -> 252615433121, Taariikh: 25/10/25 5:18:17 ");
    }

    public static void emailActivity() {
        inputReader.nextLine();
        System.out.println("5. Email Me My ACtivity");
        System.out.println("Fadlan Geli email kaaga:");
        String userEmail = inputReader.nextLine();
        for (int attempts = 0; attempts < 5 && (!userEmail.contains("@") || !userEmail.contains(".")); attempts++) {
            System.out.println("Email-ka aad gelisay ma ahan mid sax ah!");
            System.out.println("Fadlan geli email sax ah:");
            userEmail = inputReader.nextLine();
            if (attempts == 4 && (!userEmail.contains("@") || !userEmail.contains("."))) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        System.out.println("Fadlan Geli taarikhda hore (MAALIN/BISHA/SANAD, e.g:01/04/2017)");
        String startDate = inputReader.nextLine();
        System.out.println("Fadlan Geli taarikhda danbe (MAALIN/BISHA/SANAD, e.g:30/04/2017)");
        String endDate = inputReader.nextLine();

        System.out.println("Your request is being processed and the activity will be emailed to " + userEmail);
    }

    public static void salaamBank() {
        System.out.println("Salaam Bank\n" +
                "1. Itus Haraaga\n" +
                "2. Lacag dhigasho\n" +
                "3. Lacag qaadasho\n" +
                "4. Ka Wareeji EVCPlus\n" +
                "5. Ka Wareeji Account-kaga\n" +
                "6. Hubi wareejin account\n" +
                "7. Maareynta Bankiga\n" +
                "8. Kala Bax");
        int bankOption = inputReader.nextInt();
        if (bankOption < 1 || bankOption > 8) {
            System.out.println("Fadlan dooro number sax ah ");
            return;
        }

        switch (bankOption) {
            case 1:
                checkBankBalance();
                break;
            case 2:
                bankDeposit();
                break;
            case 3:
                bankWithdrawal();
                break;
            case 4:
                transferFromBankToEVCPlus();
                break;
            case 5:
                transferBetweenAccounts();
                break;
            case 6:
                verifyTransfer();
                break;
            case 7:
                bankManagement();
                break;
            case 8:
                withdrawFromBank();
                break;
        }
    }

    public static void checkBankBalance() {
        System.out.println("Koontadaada Bangiga:" + ACCOUNT_NUMBER + " " + "Haraageedu waa:" + bankAccountBalance + "USD\n" +
                "IBAN: SO 45 0007 108 500065467843");
    }

    public static void bankDeposit() {
        int depositDetails = 0;
        System.out.println("Fadlan Geli Lacagta ");
        int depositAmount = inputReader.nextInt();
        for (int attempts = 0; attempts < 5 && depositDetails != depositAmount; attempts++) {
            System.out.println("Fadlan Geli Macluumaad ");
            depositDetails = inputReader.nextInt();
            if (depositDetails != depositAmount) {
                System.out.println("Invalid input format(dataType)");
            }
            if (attempts == 4 && depositDetails != depositAmount) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        int enteredBankPin = 0;
        for (int attempts = 0; attempts < 5 && enteredBankPin != BANK_PIN; attempts++) {
            System.out.println("Fadlan Geli Numberkaaga sirta ee bangiga");
            enteredBankPin = inputReader.nextInt();
            if (attempts == 4 && enteredBankPin != BANK_PIN) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        System.out.println("Ma hubtaa inaad $" + depositAmount + " " + " dhigatid Account-kaaga bangiga?\n" +
                "1.Haa\n" +
                "2.Maya");
        int confirmDeposit = inputReader.nextInt();
        if (bankAccountBalance < depositAmount) {
            System.out.println("Haraaga koontadan" + " " + ACCOUNT_NUMBER + " " + "kuma filna.");
            return;
        }

        if (confirmDeposit == 1) {
            bankAccountBalance -= depositAmount;
            System.out.println("Waxaad $" + depositAmount + " " + "dhigtay Account-kaaga bangiga " +
                    "Haraagaagu waa $" + bankAccountBalance);
        } else if (confirmDeposit == 2) {
            System.out.println("Mahadsanid");
        } else {
            System.out.println("Mahadsanid");
        }
    }

    public static void bankWithdrawal() {
        int withdrawalDetails = 0;
        System.out.println("Fadlan Geli Lacagta ");
        int withdrawalAmount = inputReader.nextInt();
        for (int attempts = 0; attempts < 5 && withdrawalDetails != withdrawalAmount; attempts++) {
            System.out.println("Fadlan Geli Macluumaad ");
            withdrawalDetails = inputReader.nextInt();
            if (withdrawalDetails != withdrawalAmount) {
                System.out.println("Invalid input format(dataType)");
            }
            if (attempts == 4 && withdrawalDetails != withdrawalAmount) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        int enteredBankPin = 0;
        for (int attempts = 0; attempts < 5 && enteredBankPin != BANK_PIN; attempts++) {
            System.out.println("Fadlan Geli Numberkaaga sirta ee bangiga");
            enteredBankPin = inputReader.nextInt();
            if (attempts == 4 && enteredBankPin != BANK_PIN) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        System.out.println("Ma hubtaa inaad $" + withdrawalAmount + " " + "ka qaadatid  Account-kaaga bangiga?\n" +
                "1.Haa\n" +
                "2.Maya");
        int confirmWithdrawal = inputReader.nextInt();
        if (bankAccountBalance < withdrawalAmount) {
            System.out.println("Haraaga koontadan" + " " + ACCOUNT_NUMBER + " " + "kuma filna.");
            return;
        }

        if (confirmWithdrawal == 1) {
            bankAccountBalance -= withdrawalAmount;
            System.out.println("Waxaad $" + withdrawalAmount + " " + "ka qaadatay Account-kaaga bangiga " +
                    "Haraagaagu waa $" + bankAccountBalance);
        } else {
            System.out.println("Mahadsanid");
        }
    }

    public static void transferFromBankToEVCPlus() {
        System.out.println("Fadlan dooro xisaabta Bangiga\n" +
                "1. SALAAM SOMALI BANK\n" +
                "2. Salaam Sch\n" +
                "3. Bank Beeraha\n" +
                "4. Darasalaam Bank\n" +
                "5. MyBank LTD");
        int bankSelection = inputReader.nextInt();
        if (bankSelection < 1 | bankSelection > 5) {
            System.out.println("Fadlan dooro number sax ah");
            return;
        }

        System.out.println("Fadlan Geli Account");
        int inputAccount = inputReader.nextInt();
        if (inputAccount != ACCOUNT_NUMBER) {
            System.out.println("Fadlan Geli account sax ah");
            return;
        }

        long inputTransactionId = 0L;
        int attempts = 0;
        for (attempts = 0; attempts < 5 && inputTransactionId != TRANSACTION_ID; attempts++) {
            System.out.println("Fadlan Geli Macluumaad:");
            inputTransactionId = inputReader.nextLong();
        }

        if (attempts == 4 && inputTransactionId != TRANSACTION_ID) {
            System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
            return;
        }

        System.out.println("Fadlan Geli lacagta:");
        int transferAmount = inputReader.nextInt();
        if (bankAccountBalance < transferAmount) {
            System.out.println("Haraaga koontadan" + " " + ACCOUNT_NUMBER + " " + "kuma filna.");
            return;
        }

        System.out.println("Ma hubtaa inaad $" + transferAmount +
                " u wareejiso Bank Account ABDIWALI ABDULLAHI GULED (65467843)?\n" +
                "1. Haa\n" +
                "2. Maya");
        int confirmTransfer = inputReader.nextInt();
        if (confirmTransfer == 1) {
            bankAccountBalance -= transferAmount;
            System.out.println("Waxaad $" + transferAmount +
                    " u wareejisay Bank Account ABDIWALI ABDULLAHI GULED (65467843)");
            System.out.println("Haraagaagu cusub waa $" + bankAccountBalance);
        } else {
            System.out.println("Mahadsanid");
        }
    }

    public static void transferBetweenAccounts() {
        System.out.println("Fadlan Geli Account ama Mobile:");
        long accountOrMobile = inputReader.nextLong();
        if (accountOrMobile != 65467843 && accountOrMobile != 252617353733L) {
            System.out.println("Invalid Account Number.");
            return;
        }

        System.out.println("Fadlan Geli lacagta:");
        int accountTransfer = inputReader.nextInt();

        int transferDetails = 0;
        for (int attempts = 0; attempts < 5 && transferDetails != accountTransfer; attempts++) {
            System.out.println("Fadlan geli macluumaad:");
            transferDetails = inputReader.nextInt();

            if (transferDetails != accountTransfer) {
                System.out.println("Macluumaadka aad gelisay waa khalad.");
            }

            if (attempts == 4 && transferDetails != accountTransfer) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        int bankPin = 0;
        for (int attempts = 0; attempts < 5 && bankPin != BANK_PIN; attempts++) {
            System.out.println("Fadlan Geli Numberkaaga sirta ee Bangiga:");
            bankPin = inputReader.nextInt();

            if (bankPin != BANK_PIN) {
                System.out.println("Fadlan iska hubi number sireedka aad isticmaashay ee Bangiga.");
            }

            if (attempts == 4 && bankPin != BANK_PIN) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        System.out.println("Ma hubtaa inaad USD" + accountTransfer +
                " u wareejiso Bank Account: ABDIWALI ABDULLAHI GULED (7353733)?\n" +
                "1. Haa\n" +
                "2. Maya");
        int confirmAccountTransfer = inputReader.nextInt();
        if (confirmAccountTransfer == 1) {
            if (bankAccountBalance >= accountTransfer) {
                bankAccountBalance -= accountTransfer;
                System.out.println("Waxaad USD" + accountTransfer +
                        " u wareejisay Bank Account: ABDIWALI ABDULLAHI GULED (37614522)");
                System.out.println("Haraagaagu cusub waa USD" + bankAccountBalance);
            } else {
                System.out.println("Haraaga koontadan kuma filna.");
            }
        } else {
            System.out.println("Mahadsanid");
        }
    }

    public static void verifyTransfer() {
        System.out.println("Fadlan Geli OTP");
        int otpInput = inputReader.nextInt();
        if (OTP_CODE == otpInput) {
            System.out.println("Ma hubtaa in aad aqbasho lacag diridan\n1. Haa \n2. Maya");
            int confirmOTP = inputReader.nextInt();
            if (confirmOTP == 1)
                System.out.println("Waad ku guulaysatay in aad ku dirto lacagta Account to Account");
            else
                System.out.println("Mahadsanid!");
        } else {
            System.out.println("OTP not found");
        }
    }

    public static void bankManagement() {
        System.out.println("Maareynta Bankiga");
        System.out.println("1. Bedel PIN-ka Bangiga Number");
        System.out.println("2. Bedel Passwordka Ebank");
        int manageChoice = inputReader.nextInt();
        if (manageChoice < 1 || manageChoice > 2) {
            System.out.println("Fadlan geli number sax ah");
            return;
        }

        if (manageChoice == 1) {
            changeBankPin();
        } else if (manageChoice == 2) {
            changeBankPassword();
        }
    }

    public static void changeBankPin() {
        System.out.println("Fadlan Geli Numberkaaga sirta ee Bangiga");
        int currentBankPin = inputReader.nextInt();

        if (currentBankPin != OLD_BANK_PIN) {
            System.out.println("Fadlan iska hubi number sireed ka aad isticmaashay ee bangiga");
            return;
        }

        System.out.print("Fadlan geli PIN-ka Cusub: ");
        int newBankPin = inputReader.nextInt();
        System.out.println("Hubi PIN-kaaga cusub:");
        int confirmNewPin = inputReader.nextInt();

        if (newBankPin == OLD_BANK_PIN) {
            System.out.println("Fadlan iska hubi Number sireed ka cusub inuusan la mid ahayn Number sireed kaagi hore ee bangiga");
        } else {
            int attempts = 0;
            while (newBankPin != confirmNewPin && attempts < 4) {
                attempts++;
                System.out.println("IMPUT MISMATCH" +
                        " Hubi PIN-kaaga cusub:");
                confirmNewPin = inputReader.nextInt();
            }

            if (newBankPin == confirmNewPin) {
                System.out.println("<-EVCPlus-> Waad ku guulaysatay in aad badesho PIN-kaaga Bangiga");
            } else {
                System.out.println("Waxaad gaartay tirada isku dayga ugu badan. Fadlan dib usoo gal.");
                return;
            }
        }
    }

    public static void changeBankPassword() {
        System.out.println("Fadlan Geli Numberkaaga sirta ee Bangiga");
        int enteredPin = inputReader.nextInt();

        if (enteredPin != BANK_PIN) {
            System.out.println("Fadlan iska hubi number sireed ka aad isticmaashay ee bangiga");
            return;
        }

        System.out.print("Fadlan geli PIN-ka Cusub: ");
        int newPassword = inputReader.nextInt();
        int confirmPassword = 0;
        while (BANK_PIN != confirmPassword) {
            System.out.println("Hubi PIN-kaaga cusub:");
            confirmPassword = inputReader.nextInt();
            if (BANK_PIN != confirmPassword) {
                System.out.println("IMPUT MISMATCH");
                return;
            }

            if (newPassword == BANK_PIN) {
                System.out.println("Fadlan iska hubi Numer sireed ka cusub inuusan la mid ahayn Number sireed kaagi hore ee bangiga");
                return;
            }
            if (newPassword == confirmPassword) {
                System.out.println("<-EVCPlus-> Waad ku guulaysatay in aad badesho PIN-kaaga Bangiga");
            } else {
                System.out.println("Waxaad gaartay tirada isku dayga ugu badan. Fadlan dib usoo gal.");
                return;
            }
        }
    }

    public static void withdrawFromBank() {
        int enteredCode = 0;
        for (int attempts = 0; attempts < 5 && enteredCode != WITHDRAWAL_CODE; attempts++) {
            System.out.println("Fadlan Geli aqoonsiga codsiga: ");
            enteredCode = inputReader.nextInt();
            if (enteredCode != WITHDRAWAL_CODE) {
                System.out.println("Invalid input format(dataType)");
            }
            if (attempts == 4) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            }
        }

        System.out.println("fadlan geli lacagta");
        int withdrawalAmount = inputReader.nextInt();

        if (bankAccountBalance < withdrawalAmount) {
            System.out.println("Haraaga xisabtaada kuma filna");
            return;
        }

        System.out.println("Mahubtaa inaad kala baxdid $" + withdrawalAmount + "?");
        System.out.println("1.Haa");
        System.out.println("2.Maya");
        int confirmWithdrawal = inputReader.nextInt();

        if (confirmWithdrawal == 1) {
            bankAccountBalance -= withdrawalAmount;
            System.out.println("Waxaad kala baxday $" + withdrawalAmount + " haraagaagu waa $" + bankAccountBalance);
            return;
        }
        System.out.println("Mahadsanid");
    }

    public static void management() {
        System.out.println("Maareynta\n" +
                "1. Bedel lambarka sirta ah\n" +
                "2. Bedel Luqadda\n" +
                "3. Wargelin Mobile Lumay\n" +
                "4. Lacag Xirasho\n" +
                "5. U celi lacag qaldantay");
        int managementOption = inputReader.nextInt();
        if (managementOption < 1 || managementOption > 5) {
            System.out.println("Fadlan dooro number sax ah");
            return;
        }

        switch (managementOption) {
            case 1:
                changePin();
                break;
            case 2:
                changeLanguage();
                break;
            case 3:
                reportLostMobile();
                break;
            case 4:
                blockMoney();
                break;
            case 5:
                refundMoney();
                break;
        }
    }

    public static void changePin() {
        System.out.println("Fadlan Geli PIN-kaaga cusub");
        int newPin = inputReader.nextInt();
        int confirmPin = 0;
        for (int attempts = 0; attempts < 5 && confirmPin != newPin; attempts++) {
            System.out.println("Hubi PIN-kaaga cusub");
            confirmPin = inputReader.nextInt();
            if (confirmPin != newPin) {
                System.out.println("Invalid input format(length)");
            }
            if (attempts == 4 && confirmPin != newPin) {
                System.out.println("waxaad gaaratay inta ku noqosho laguu ogalaa, fadlan dib usoo gal");
                return;
            } else if (confirmPin == newPin) {
                System.out.println("Waad badashay PINKA macmaiil");
                return;
            }
        }
    }

    public static void changeLanguage() {
        int languageChoice = 0;
        while (languageChoice < 1 || languageChoice > 2) {
            System.out.println();
            System.out.println("Fadlan dooro luqada\n" +
                    "1. English\n" +
                    "2. Somali");
            languageChoice = inputReader.nextInt();
            if (languageChoice < 1 || languageChoice > 2) {
                System.out.println(" ");
            }
        }
        if (languageChoice == 1) {
            System.out.println("<-EVCPlus- > You have successfully changed\n" +
                    "your language");
        } else if (languageChoice == 2) {
            System.out.println("<-EVCPlus- > You have successfully changed\n" +
                    "your language");
        }
    }

    public static void reportLostMobile() {
        System.out.println("Fadlan Geli Mobile ka Lumay");
        int lostMobile = inputReader.nextInt();
        System.out.println("Fadlan Geli Numberkiisa Sirta ah");
        int lostMobilePin = inputReader.nextInt();
        System.out.println("Ma hubtaa in aad u diiwaan Geliso lumid number-kan" + " " + lostMobile + "?\n" +
                "1.Haa\n" +
                "2.Maya");
        int confirmReport = inputReader.nextInt();
        if (confirmReport == 1) {
            System.out.println("Waad Diwaan galisay lumid number - kan" + " " + lostMobile);
        } else {
            System.out.println("Mahadsanid");
        }
    }

    public static void blockMoney() {
        System.out.println("Fadlan Geli number-ka khalad-ka ah");
        int wrongNumber = inputReader.nextInt();
        System.out.println("Fadlan Geli number-kii loo rabay");
        int correctNumber = inputReader.nextInt();
        System.out.println("Ma hubtaa in aad xirto lacagtan?\n" +
                "1. Haa\n" +
                "2. Maya");
        int confirmBlock = inputReader.nextInt();
        if (confirmBlock == 1) {
            System.out.println("Waad xirtay lacagtaan");
        } else {
            System.out.println("Mahadsanid");
        }
    }

    public static void refundMoney() {
        System.out.println("Fadlan Geli aqoonsiga lacag diridda");
        int transactionId = inputReader.nextInt();
        System.out.println("Fadlan Geli Macluumaad");
        int transactionDetails = inputReader.nextInt();
        System.out.println("Ma hubtaa in aad celiso lacagta?\n" +
                "1. Haa\n" +
                "2. Maya");
        int confirmRefund = inputReader.nextInt();
        if (confirmRefund == 1) {
            System.out.println("Waad celisay lacagtan");
        } else {
            System.out.println("Mahadsanid");
        }
    }

    public static void taajServices() {
        System.out.println("TAAJ\n" +
                "1. Gudaha\n" +
                "2. Dibadda\n" +
                "3. Ogoow Khidmada\n" +
                "4. Macluumadka xawaaladda\n" +
                "5. Jooji Xawaaladda\n" +
                "6. Fur Xawaaladda\n");
        int taajOption = inputReader.nextInt();
        if (taajOption < 1 || taajOption > 6) {
            System.out.println("Fadlan dooro number sax ah");
            return;
        }

        switch (taajOption) {
            case 1:
                domesticTransfer();
                break;
            case 2:
                internationalTransfer();
                break;
            case 3:
                taajServiceInfo();
                break;
            case 4:
                transferInfo();
                break;
            case 5:
                stopTransfer();
                break;
            case 6:
                enableTransfer();
                break;
        }
    }

    public static void domesticTransfer() {
        System.out.println("Fadlan dooro shirkada\n" +
                "1. E-KAAFI\n" +
                "2. E-SAHAL");
        int companyChoice = inputReader.nextInt();
        inputReader.nextLine();
        if (companyChoice == 1) {
            processDomesticTransfer("E-KAAFI");
        } else if (companyChoice == 2) {
            processDomesticTransfer("E-SAHAL");
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void processDomesticTransfer(String company) {
        System.out.println("Fadlan Geli Taleefanka qaataha");
        int recipientPhone = inputReader.nextInt();
        inputReader.nextLine();
        System.out.println("Fadlan Geli Magaca qaataha oo seddexan");
        String recipientName = inputReader.nextLine();

        System.out.println("Fadlan Geli Magaalada qaataha uu joogo");
        String recipientCity = inputReader.nextLine();

        System.out.println("Fadlan Geli lacagta");
        int transferAmount = inputReader.nextInt();
        System.out.println("Khidmada ma xisaabtada ayaa laga jarayaa?");
        System.out.println("1.Haa");
        System.out.println("2.Maya");
        int confirmCharge = inputReader.nextInt();
        if (confirmCharge == 1) {
            System.out.println("Mahubtaa inaad $" + " " + transferAmount + " " +
                    "u dirtid " + recipientName + " oo wata Taleefanka " + recipientPhone);
            System.out.println("1.Haa");
            System.out.println("2.Maya");
            confirmCharge = inputReader.nextInt();
            if (confirmCharge == 1) {
                bankAccountBalance -= transferAmount;
                if (bankAccountBalance < transferAmount) {
                    System.out.println("Haraagaagu kuguma filna");
                } else {
                    System.out.println("Waxaad lacag $" + transferAmount + " u dhigtay TAAJ " + recipientName +
                            " oo joogo magaalada " + recipientCity + ". Haraaga kontadan " + transferAmount +
                            " waa $" + bankAccountBalance);
                }
            }
        } else {
            System.out.println("Lacag lama jarin. Waad ka laabatay.");
        }
    }

    public static void internationalTransfer() {
        System.out.println("Fadlan Geli Taleefanka qaataha");
        int internationalPhone = inputReader.nextInt();
        inputReader.nextLine();
        System.out.println("Fadlan Geli Magaca qaataha oo seddexan");
        String internationalName = inputReader.nextLine();
        System.out.println("Fadlan Geli Magaalada qaataha uu joogo");
        String internationalCity = inputReader.nextLine();
        System.out.println("Fadlan Geli Lacagta");
        int internationalAmount = inputReader.nextInt();
        System.out.println("Fadlan Geli Macluumaad");
        internationalAmount = inputReader.nextInt();
        System.out.println("Khidmada ma xisaabtada ayaa laga jarayaa\n1.Haa ");
        int confirmInternational = inputReader.nextInt();
        if (confirmInternational == 1) {
            System.out.println("Ma hubtaa inaad $" + internationalAmount + " u dirtid " + internationalName + " oo wata taleefoonka " + internationalPhone + "?  \n1.Haa \n2. Maya ");
            confirmInternational = inputReader.nextInt();
            if (confirmInternational == 1) {
                bankAccountBalance -= internationalAmount;
                if (bankAccountBalance < internationalAmount) {
                    System.out.println("Haraagaagu kuguma filna");
                } else {
                    System.out.println("waxaad $" + internationalAmount + " u dirtay " + internationalName + " oo wata taleefoonka " +
                            internationalPhone + " Haraagagu waa " + bankAccountBalance);
                }
            } else {
                System.out.println("Mahadsanid!");
            }
        } else {
            System.out.println("Mahadsanid!");
        }
    }

    public static void taajServiceInfo() {
        System.out.println("Fadlan dooro shirkada\n" +
                "1. PAY TO EVCPLUS TMT\n" +
                "2. TAAJ\n" +
                "3. TaajPay\n" +
                "4. New Etaaj\n" +
                "5.TAAJ IPS");
        int taajService = inputReader.nextInt();
        if (taajService < 1 || taajService > 5) {
            System.out.println("Fadlan dooro number sax ah");
            return;
        }

        System.out.println("Fadlan Geli Taleefanka qaataha");
        int servicePhone = inputReader.nextInt();
        System.out.println("Fadlan Geli lacagta");
        int serviceAmount = inputReader.nextInt();
        System.out.println("mahubtaa inaad $" + serviceAmount + " " + "u dirto tel No " + servicePhone);
        System.out.println("1.Haa");
        System.out.println("2.Maya");
        int confirmService = inputReader.nextInt();
        if (confirmService == 1) {
            bankAccountBalance -= serviceAmount;
            if (bankAccountBalance < serviceAmount) {
                System.out.println("Haraaga koontadan" + " " + ACCOUNT_NUMBER + " " + "kuma filna");
                return;
            }
            System.out.println("Waxaad $" + serviceAmount + " " + "u dirtay tell No " + " " + servicePhone +
                    "haraagaagu waa" + bankAccountBalance);
        } else {
            System.out.println("Mahadsanid");
        }
    }

    public static void transferInfo() {
        System.out.println("Fadlan Geli aqoonsiga lacag diridda");
        int transferId = inputReader.nextInt();
        int transferDetails = 0;
        while (transferDetails != transferId) {
            System.out.println("Fadlan Geli Macluumaad");
            transferDetails = inputReader.nextInt();
            if (transferDetails != transferId) {
                System.out.println("Invalid Input match (length)");
                return;
            } else if (transferDetails == transferId) {
                System.out.println("Mahubtaa in aad xirto aqoonsiga xawilaada" + transferId + "?");
                System.out.println("1.Haa");
                System.out.println("2.Maya");
                int confirmTransfer = inputReader.nextInt();
                if (confirmTransfer == 1) {
                    System.out.println("Waxaad xirtay" + " " + "aqoonsiga xawilaada " + " " + transferId);
                } else {
                    System.out.println("Mahadsanid");
                }
            }
        }
    }

    public static void stopTransfer() {
        System.out.println("Fadlan Geli aqoonsiga lacag diridda");
        int transferId = inputReader.nextInt();
        System.out.println("Fadlan Geli Macluumaad");
        int transferInfo = inputReader.nextInt();

        if (transferInfo != transferId) {
            System.out.println("Invalid Input match (length)");
            return;
        } else {
            System.out.println("Mahubtaa in aad xirto aqoonsiga xawilaada " + transferId + "?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            int confirmTransfer = inputReader.nextInt();

            if (confirmTransfer == 1) {
                System.out.println("Waxaad xirtay aqoonsiga xawilaada " + transferId);
            } else {
                System.out.println("Mahadsanid");
            }
        }
    }

    public static void enableTransfer() {
        System.out.println("Fadlan Geli aqoonsiga lacag diridda");
        int transferId = inputReader.nextInt();
        int transferDetails = 0;
        while (transferDetails != transferId) {
            System.out.println("Fadlan Geli Macluumaad");
            transferDetails = inputReader.nextInt();
            if (transferDetails != transferId) {
                System.out.println("Invalid Input match (length)");
                return;
            } else if (transferDetails == transferId) {
                System.out.println("Mahubtaa in aad lacag u dirto aqoonsiga xawilaada" + transferId + "?");
                System.out.println("1.Haa");
                System.out.println("2.Maya");
                int confirmTransfer = inputReader.nextInt();
                if (confirmTransfer == 1) {
                    System.out.println("Waxaad lacag u dirtay" + " " + "aqoonsiga xawilaada " + " " + transferId);
                } else {
                    System.out.println("Mahadsanid");
                }
            }
        }
    }

    public static void billPaymentOption() {
        System.out.println("EVCPlus");
        System.out.println("1.itus haraaaga bill ka\n" +
                "2.Wada Bixi bill ka\n" +
                "3.Qayb ka bixi Bill");
        int billPaymentOption = inputReader.nextInt();
        if (billPaymentOption < 1 || billPaymentOption > 3) {
            System.out.println("Fadlan dooro number sax ah");
            return;
        }

        switch (billPaymentOption) {
            case 1:
                checkBillBalance();
                break;
            case 2:
                payFullBill();
                break;
            case 3:
                payPartialBill();
                break;
        }
    }

    public static void checkBillBalance() {
        System.out.println("Fadlan Geli bill reference number");
        int billReference = inputReader.nextInt();
        if (BILL_REFERENCE != billReference) {
            System.out.println("some parameters are missing. please check your request");
        } else {
            System.out.println("Haraagaaga bill ku waa $" + mobileBalance);
        }
    }

    public static void payFullBill() {
        System.out.println("Fadlan Geli bill reference number");
        int billReference = inputReader.nextInt();
        if (BILL_REFERENCE != billReference) {
            System.out.println("some parameters are missing. please check your request");
            return;
        }

        System.out.println("Fadlan Geli lagacta bill ka");
        int fullPayment = inputReader.nextInt();
        System.out.println("Ma hubtaa in aad wada bixiso lacagta bill ka una dirto " + billReference + "?");
        System.out.println("1.Haa");
        System.out.println("2.Maya");
        int confirmFullPayment = inputReader.nextInt();
        if (confirmFullPayment == 1) {
            mobileBalance -= fullPayment;
            if (fullPayment < 1 || fullPayment > mobileBalance) {
                System.out.println("Haraagaagu kuguma filna");
                return;
            }
            System.out.println("waad wada bixisay lacagta bill ka waxaad na udirtay " + billReference +
                    " haraagaagu waa $" + bankAccountBalance);
        } else {
            System.out.println("Mahadsanid!");
        }
    }

    public static void payPartialBill() {
        System.out.println("Fadlan Geli bill reference number");
        int billReference = inputReader.nextInt();
        if (BILL_REFERENCE != billReference) {
            System.out.println("some parameters are missing. please check your request");
            return;
        }

        System.out.println("Fadlan Geli lagacta bill ka");
        int partialPayment = inputReader.nextInt();
        System.out.println("Ma hubtaa in aad Qayb ka bixiso lacagta bill ka una dirto " + billReference + "?");
        System.out.println("1.Haa");
        System.out.println("1.Maya");
        int confirmPartial = inputReader.nextInt();
        if (confirmPartial == 1) {
            mobileBalance -= partialPayment;
            if (partialPayment < 1 || partialPayment > mobileBalance) {
                System.out.println("Haraagaagu kuguma filna");
                return;
            }
            System.out.println("waxaad Qayb ka bixisay lacagta bill ka waxaad na udirtay " + billReference +
                    " haraagaagu waa $" + bankAccountBalance);
        } else {
            System.out.println("Mahadsanid!");
        }
    }
}
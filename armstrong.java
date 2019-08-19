class armstrong {
    public static void main(String[] args) {
        int g = 9474;
        int x = 534494836;
        int hl = 153;
        // Test functions
        Boolean y = Armstrong(x);
        Boolean j = Armstrong(g);
        Boolean h2 = Armstrong(hl);
        // printing it out
        System.out.println(y);
        System.out.println(j);
        System.out.println(h2);
    }

    public static Boolean Armstrong(int x) {
        // convert the input
        String comp = Integer.toString(x);
        Boolean isArmStrong = false;
        int counter = 0;

        for (int i = 0; i < comp.length(); i++) {
            counter += Math.pow(Integer.parseInt(String.valueOf(comp.charAt(i))), comp.length());
        }
        System.out.println(counter);
        if (counter == x)
            return true;
        return isArmStrong;
    }
}
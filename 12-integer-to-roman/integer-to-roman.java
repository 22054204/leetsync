class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        StringBuilder sb = new StringBuilder();

        while(num >= 1000){
            sb.append(map.get(1000));
            num = num - 1000;
        }
        while(num >= 900){
            sb.append(map.get(100));
            sb.append(map.get(1000));
            num = num - 900;
        }
        while(num >= 500){
            sb.append(map.get(500));
            num = num - 500;
        }
        while(num >= 400){
            sb.append(map.get(100));
            sb.append(map.get(500));
            num = num - 400;
        }
        while(num >= 100){
            sb.append(map.get(100));
            num = num - 100;
        }
        while(num >= 90){
            sb.append(map.get(10));
            sb.append(map.get(100));
            num = num - 90;
        }
        while(num >= 50){
            sb.append(map.get(50));
            num = num - 50;
        }
        while(num >= 40){
            sb.append(map.get(10));
            sb.append(map.get(50));
            num = num - 40;
        }
        while(num >= 10){
            sb.append(map.get(10));
            num = num - 10;
        }
        while(num >= 9){
            sb.append(map.get(1));
            sb.append(map.get(10));
            num = num - 9;
        }
        while(num >= 5){
            sb.append(map.get(5));
            num = num - 5;
        }
        while(num >= 4){
            sb.append(map.get(1));
            sb.append(map.get(5));
            num = num - 4;
        }
        while(num >= 1){
            sb.append(map.get(1));
            num = num - 1;
        }
        return sb.toString();
    }
}
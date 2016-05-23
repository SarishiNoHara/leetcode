public int[] countBits(int num) {

        int[] result = new int[num + 1];

        int pow = 1;

        int p= 1;

        for(int i = 0; i <= num; i++) {

            if(i == pow) {

                result[i] = 1;

                //2^1, 2^2, 2^3 .... 

                pow <<= 1;

                p = 1;

            }else{

                result[i] = result[p]+1;

                p ++;

            }
            
        }

}

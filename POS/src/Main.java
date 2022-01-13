
public class Main  {

    public static void main(String[] args) {

         BlockChain chain1 = new BlockChain();

         int min = 0 ;
         int userId = 0;


      User Users[] = new User[10];

      Users[0] = new User(1, chain1);
      Users[1] = new User(2, chain1);
      Users[2] = new User(3, chain1);
      Users[3] = new User(4, chain1);
      Users[4] = new User(5, chain1);


      System.out.println("Random number by Blockchain is " + chain1.stakeBlockChain);
      min = Math.abs(Users[0].stakeUser - chain1.stakeBlockChain);



      for (int i = 1; i < 5; i++) {


          if (Math.abs(Users[i].stakeUser - chain1.stakeBlockChain) < min) {
              min = Math.abs(Users[i].stakeUser - chain1.stakeBlockChain);
              userId = Users[i].id;

          }
      }

       System.out.println("Id is -:" + userId);

        Users[userId - 1].start();



    }

}

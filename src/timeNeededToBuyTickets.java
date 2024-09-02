public class timeNeededToBuyTickets {
    static int timeRequiredToBuy(int[] tickets, int k) {
        int i=0;
        int time=0;
        while(tickets[k]!=0){
            if(tickets[i]!=0){
                time++;
                tickets[i]--;
                i++;
            }
            else i++;
            if(i==tickets.length) i=0;
        }
        return time;
    }
    public static void main(String[] args) {
        int[] arr={5,1,1,1};
        int k=0;
        int ans=timeRequiredToBuy(arr,k);
        System.out.println(ans);
    }
}

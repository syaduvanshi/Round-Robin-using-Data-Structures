
import java.util.*;
class LinkList
{
    String data;
    LinkList next;
    LinkList(String d)
    {
        data=d;
    }
}
public class MyClass {
    static LinkList insertEnd(LinkList head,String data)
    {
        LinkList newnode=new LinkList(data);
        if(head==null)
        {
            head=newnode;
            newnode.next=head;
        }
        else
        {
            LinkList ptr=head;
            while(ptr.next!=head)
            {
                ptr=ptr.next;
            }
            ptr.next=newnode;
            newnode.next=head;
        }
        return head;
    }
    static LinkList func(LinkList head,int bust_time[],String process_name[],int no_of_processes,int quan_no){

        for(int i=0;i<no_of_processes;i++)
        {
            if(bust_time[i]!=0)
            {

                if(quan_no>bust_time[i]){
                    head=insertEnd(head,process_name[i]);
                    bust_time[i]=0;
                }
                else{
                    head=insertEnd(head,process_name[i]);
                    bust_time[i]=bust_time[i]-quan_no;
                }

            }

        }

        return head;

    }
    static void display(LinkList head){
        LinkList ptr=head;
        System.out.print(head.data+" ");
        ptr=ptr.next;
        while(ptr!=head)
        {
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }

    }
    public static void main(String args[]) {
        LinkList head=null;
        int bust_time[]=new int[100];
        Scanner sc=new Scanner(System.in);
        int no_of_processes=sc.nextInt();
        for(int i=0;i<no_of_processes;i++)
        {
            bust_time[i]=sc.nextInt();
        }
        int quan_no=sc.nextInt();
        String process_name[]=new String[100];
        for(int i=0;i<no_of_processes;i++)
        {
            process_name[i]="P"+i;
        }
        int flag=0,val=-1;
        while(true){
            val=-1;
            head=func(head,bust_time,process_name,no_of_processes,quan_no);
            for(int i=0;i<no_of_processes;i++)
            {
                if(bust_time[i]!=0)
                {
                    val=0;
                    break;
                }

            }
            if(val!=0)
                break;
            else
                continue;


        }
        display(head);



    }
}
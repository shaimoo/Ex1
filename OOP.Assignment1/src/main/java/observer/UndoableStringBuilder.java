package observer;
import java.util.Stack;
/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {
        public StringBuilder my_string;
        public Stack<String> my_stack;

        /**
         * here we crate new StringBuilder and stack for undo function.
         */
        public UndoableStringBuilder() {
            this.my_string = new StringBuilder();
            this.my_stack = new Stack<String>();
        }
         public UndoableStringBuilder(String str) {
        this.my_string = new StringBuilder(str);
        this.my_stack = new Stack<String>();
          }
        /**
         *  here we add a string for our stringBuilder ,and we push to the stack the new string after append.
         * @param str = this is the string we append to my_string.
         */
        public void append(String str){
            this.my_string.append(str);
            String temp = my_string.toString();
            this.my_stack.add(temp);
        }
        public  void push(String str){
            this.my_stack.push(str);
        }

        /**
         * this function revers our stringBuilder and push to the stack the result of the reverse.
         */
        public void reverse()
        {
            this.my_string.reverse();
            String temp = my_string.toString();
            this.my_stack.add(temp);
        }

        /**
         * this function is pop from the stack the previous stringBuilder and update our stringBuilder.
         */
        public void undo(){
            if(my_stack.peek() != null){
                this.my_string = new StringBuilder();
                this.my_stack.pop();
                my_string.append(my_stack.peek());
                                        }
            else{
                System.out.println("there is no previous sentence");
            }
        }

        /**
         * this function delete from the stringBuilder
         * @param start:the index we start to delete our stringBuilder.
         * @param end:the index we finish to delete our stringBuilder.
         */
        public  void delete(int start , int end) {
            if(start<=end && my_string.length()>=end &&start>=0){
                my_string.delete(start,end);
                String temp = my_string.toString();
                this.my_stack.add(temp);}
            else {
                System.out.println("the start index or the end is not valid");
            }
        }

        /**
         * this function insert new string to our stringBuilder in specific location.
         * @param offset= the current location we insert to our stringBuilder.
         * @param str=this is the string we insert to our stringBuilder.
         */
        public void  insert(int offset ,String str) {
            if(offset>=0 && offset<=my_string.length() ){
                my_string.insert(offset ,str);
                String temp = my_string.toString();
                this.my_stack.add(temp);
            }  else {
                System.out.println("the offset index is not valid");
            }
        }

        /**
         * here we replace words/all the  stringBuilder value.
         * @param start=the start index in the stringBuilder we replace.
         * @param end=the end index in the stringBuilder we replace.
         * @param str=the string we put in the stringBuilder.
         */

        public void replace(int start , int end , String str) {
            if(start>=0 && start<=end &&end<=my_string.length()){
                my_string.delete(start,end);
                my_string.insert(start,str);
                String temp = my_string.toString();
                this.my_stack.add(temp);}
            else {
                System.out.println("the start index or the end is not valid");
            }

        }

        /**
         * function parse to string.
         * @return the string.
         */
        @Override
        public String toString() {
            return my_string.toString();
        }
}


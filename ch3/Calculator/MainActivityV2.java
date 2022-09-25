public class MainActivityV2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        TextView labelResult = (TextView) findViewById(R.id.labelResult);
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        int result = 0;

        String str1 = input1.getText().toString();
        String str2 = input2.getText().toString();

        if (!str1.equals("") && !str2.equals("")) {
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);
            switch (view.getId()) {
                case R.id.buttonAdd:
                    result = num1 + num2;
                    labelResult.setText("Result:" + result);
                    break;
                case R.id.buttonSubtract:
                    result = num1 - num2;
                    labelResult.setText("Result:" + result);
                    break;
                case R.id.buttonMultiply:
                    result = num1 * num2;
                    labelResult.setText("Result:" + result);
                    break;
                case R.id.buttonDivide:
                    if (num2 != 0) {
                        result = num1 / num2;
                        labelResult.setText("Result:" + result);
                    } else {
                        labelResult.setText("a");
                    }
                    break;
            }
        } else {
            labelResult.setText("Please enter two operands.");
        }
    }
}

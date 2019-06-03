package sundarchaupal.otplogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText mobile;
    Button cont;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobile=findViewById(R.id.mobile);
        cont=findViewById(R.id.cont);
        auth=FirebaseAuth.getInstance();
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=mobile.getText().toString().trim();
                if (phone.isEmpty() || phone.length()<10)
                {
                    mobile.setError("Enter Valid no");
                    mobile.requestFocus();
                    return;
                }
                Intent intent=new Intent(MainActivity.this,PhoneVarifyActivity.class);
                intent.putExtra("mobile",phone);
                startActivity(intent);

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=auth.getCurrentUser();
        if (user!=null)

        {
            Intent intent=new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
    }
}

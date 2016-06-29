package com.test.login.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.test.login.R;
import com.test.login.Util.UserInforUtil;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText et_pass;
    EditText mEt_username;
    CheckBox mCb_rem;
    Button mBt_login;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;

        mEt_username = (EditText) findViewById(R.id.edit_name);
        et_pass = (EditText) findViewById(R.id.edit_pass);
        mCb_rem = (CheckBox) findViewById(R.id.ischeck);
        mBt_login = (Button) findViewById(R.id.btlogin);
        mBt_login.setOnClickListener(this);

        Map<String,String> map=UserInforUtil.getUserInfo();
        if(map !=null){
            String username=map.get("username");
            String pass=map.get("password");
            mEt_username.setText(username);
            et_pass.setText(pass);
        }
        
    }

    @Override
    public void onClick(View v) {

        String username=mEt_username.getText().toString();
        String userpass=et_pass.getText().toString();
        boolean ischeck=mCb_rem.isChecked();

        switch (v.getId()){
            case R.id.btlogin :{
                if(TextUtils.isEmpty(username)||TextUtils.isEmpty(userpass)){
                    Toast.makeText(mContext,"用户名或者密码不能为空！",Toast.LENGTH_SHORT).show();
                }
            }

        }

        if (ischeck){
            boolean result= UserInforUtil.saveUserInfo(username,userpass);
            if(result){
                Toast.makeText(mContext,"密码保存成功",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(mContext,"密码保存失败",Toast.LENGTH_SHORT).show();
            }
        }else {

            Toast.makeText(mContext,"无需保存",Toast.LENGTH_SHORT).show();
        }

    }
}

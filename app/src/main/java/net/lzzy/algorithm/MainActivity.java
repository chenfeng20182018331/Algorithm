package net.lzzy.algorithm;

import android.net.sip.SipAudioCall;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.algorlib.BaseSort;
import net.lzzy.algorithm.algorlib.DirectSort;
import net.lzzy.algorithm.algorlib.SearchFactort;
import net.lzzy.algorithm.algorlib.SortFactory;

import java.security.Principal;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
     private  Spinner spinner;
    private   LinkageError container;
    private  Spinner  spSearch;
    private Button btnSort;
    private View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      initViews();
      initSpinner();
      initSearch();
    }


    private void initSearch() {
        Spinner spSearch=findViewById(R.id.activity_main_sp_search);
        spSearch.setAdapter(new ArrayAdapter<>(this,
        android.R.layout.simple_spinner_dropdown_item,SearchFactort.getSortNames()));
        LinearLayout container=findViewById(R.id.activity_main_btn_container);
        findViewById(R.id.activity_main_sp_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSearch();
            }
        });
    }

    private void resetSearch() {
        generateItems();
        btnSort.callOnClick();
        for (Integer i :items){
            Button btn=new Button(this);
            btn.setText(String.format(i.toString(), Locale.CANADA));
            btn.setId(i);
            btn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1));
            btn.setOnClickListener(listener);

        }

    }





    private  void initSpinner(){
        Spinner spinner=findViewById(R.id.activity_main_btn_sp);
        // String[] names={"选择排序","直接插入排序","希尔排序"};
        spinner.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,SortFactory.getSortNames()));

    }


private  void initViews(){
    edtItems = findViewById(R.id.activity_main_edt_items);
    findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
    findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
    tvResult = findViewById(R.id.activity_main_tv_result);


}


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                BaseSort<Integer> sort=SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
                BaseSort<Integer> sortNotNull= Objects.requireNonNull(sort);
                sortNotNull.getDuration();
                String result=sortNotNull.getResult();
                tvResult.setText(result);
                Toast.makeText(this, "总时长"+sort.getDuration(), Toast.LENGTH_SHORT).show();
                //DirectSort sort=new DirectSort(items);
               // sort.sort();



               // insertSort();
              //  displayItems(tvResult);
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);

    }

    private void directSort() {
        //todo:直接选择排序的具体实现
        //分为有序区和无序区。每一趟都在无序区以此对比。记录对比区域的最小2的位置。
        // 然后无序区第一个好玩所记录的最小元素进行交换，无序区少一个，有序区多一个，循环往复直之无序区。
        // 元素数量为0
        for(int i=0;i<items.length-1;i++){
            int minpos=i;
            for (int j=i+1;j<items.length;j++){
                if (items[minpos].compareTo(items[j])>0){
                    minpos=j;
                }
            }
            swap(minpos,i);
        }

    }
    //插入排序1
    public  void insertSort(){
        for(int i=1;i<items.length;i++){
            int j=i-1;
            if(items[j].compareTo(items[i])<0){
                continue;
            }
            Integer tmp=items[i];
            while (i>=0&&items[j].compareTo(tmp)>0){
                items[j+1]=items[j];
                j--;

            }
            items[j+1]=tmp;
        }
    }
    private void swap(int m, int n) {
        int tmp=items[m];
        items[m] = items[n];
        items[n]=tmp;
//
    }




    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}

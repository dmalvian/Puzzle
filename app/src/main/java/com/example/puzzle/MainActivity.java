package com.example.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI;
    List<String> listCorrect, listGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
        initList();
        initNewGame();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_a:
                moveBlock(0);
                break;
            case R.id.btn_b:
                moveBlock(1);
                break;
            case R.id.btn_c:
                moveBlock(2);
                break;
            case R.id.btn_d:
                moveBlock(3);
                break;
            case R.id.btn_e:
                moveBlock(4);
                break;
            case R.id.btn_f:
                moveBlock(5);
                break;
            case R.id.btn_g:
                moveBlock(6);
                break;
            case R.id.btn_h:
                moveBlock(7);
                break;
            case R.id.btn_i:
                moveBlock(8);
                break;
        }
    }

    private void initButtons() {
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        btnD = findViewById(R.id.btn_d);
        btnE = findViewById(R.id.btn_e);
        btnF = findViewById(R.id.btn_f);
        btnG = findViewById(R.id.btn_g);
        btnH = findViewById(R.id.btn_h);
        btnI = findViewById(R.id.btn_i);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnF.setOnClickListener(this);
        btnG.setOnClickListener(this);
        btnH.setOnClickListener(this);
        btnI.setOnClickListener(this);
        btnA.setOnClickListener(this);
    }

    private void initList() {
        List<String> labels = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", " ");

        listCorrect = new ArrayList();
        listCorrect.addAll(labels);

        listGame = new ArrayList<>();
        listGame.addAll(labels);
    }

    private void initNewGame() {
        Collections.shuffle(listGame);
        syncBlocks();
    }

    private void moveBlock(Integer index) {
        Integer emptyIndex = listGame.indexOf(" ");

        List<Integer> moveableBlocks = getMoveableBlock(emptyIndex);

        if (moveableBlocks.contains(index)) {
            Collections.swap(listGame, index, emptyIndex);
        }

        syncBlocks();
        checkCorrect();
    }

    private void syncBlocks() {
        btnA.setText(listGame.get(0));
        btnB.setText(listGame.get(1));
        btnC.setText(listGame.get(2));
        btnD.setText(listGame.get(3));
        btnE.setText(listGame.get(4));
        btnF.setText(listGame.get(5));
        btnG.setText(listGame.get(6));
        btnH.setText(listGame.get(7));
        btnI.setText(listGame.get(8));
    }

    private void checkCorrect() {
        if (listGame.equals(listCorrect)) {
            Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Integer> getMoveableBlock(Integer index) {
        List<Integer> moveableBlocks = new ArrayList<>();
        switch (index) {
            case 0:
                moveableBlocks.add(1);
                moveableBlocks.add(3);
                break;
            case 1:
                moveableBlocks.add(0);
                moveableBlocks.add(2);
                moveableBlocks.add(4);
                break;
            case 2:
                moveableBlocks.add(1);
                moveableBlocks.add(5);
                break;
            case 3:
                moveableBlocks.add(0);
                moveableBlocks.add(4);
                moveableBlocks.add(6);
                break;
            case 4:
                moveableBlocks.add(1);
                moveableBlocks.add(3);
                moveableBlocks.add(5);
                moveableBlocks.add(7);
                break;
            case 5:
                moveableBlocks.add(2);
                moveableBlocks.add(4);
                moveableBlocks.add(8);
                break;
            case 6:
                moveableBlocks.add(3);
                moveableBlocks.add(7);
                break;
            case 7:
                moveableBlocks.add(4);
                moveableBlocks.add(6);
                moveableBlocks.add(8);
                break;
            case 8:
                moveableBlocks.add(5);
                moveableBlocks.add(7);
                break;
        }

        return moveableBlocks;
    }
}

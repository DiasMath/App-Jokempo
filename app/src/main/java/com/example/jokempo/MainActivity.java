package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textTitulo;
    private ImageView imageResultado;
    private TextView textResultado;
    private TextView textEscolhaApp;
    private int imagemPadrao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTitulo = findViewById(R.id.textTitulo);
        textEscolhaApp = findViewById(R.id.textEscolhaApp);
        imageResultado = findViewById(R.id.imageResultado);
        textResultado = findViewById(R.id.textResultado);
        imagemPadrao = R.drawable.padrao;
        findViewById(R.id.btnJogarNovamente).setVisibility(View.GONE);
    }

    public void selecionadoPedra(View view) {
        this.OpcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.OpcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.OpcaoSelecionada("Tesoura");
    }

    public void OpcaoSelecionada(String opcaoSelecionada) {

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
                (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura")
        ) {
            textResultado.setText("Você Perdeu!");


        } else if (
                    (opcaoSelecionada == "Tesoura" && opcaoApp == "Papel") ||
                    (opcaoSelecionada == "Papel" && opcaoApp == "Pedra") ||
                    (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura")
        )
        {
            textResultado.setText("Você Ganhou!");
        }
        else {
            textResultado.setText("Empate!");
        }
        findViewById(R.id.btnJogarNovamente).setVisibility(View.VISIBLE);
    }
    public void reiniciarJogo(View view) {

        imageResultado.setImageResource(imagemPadrao);
        textResultado.setText("Escolha sua Opção:");
        findViewById(R.id.btnJogarNovamente).setVisibility(View.GONE);
    }

}
package com.example.jmfs1.ebec.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jmfs1.ebec.R;
import com.example.jmfs1.ebec.core.Product;

import java.util.List;

/**
 * Created by jeronimo on 31/12/2016.
 */

public class ShopAdapter extends ArrayAdapter<Product> {

    private Context context;
    public List<Product> products;

    public ShopAdapter(Context context, List<Product> products) {
        super(context, -1, products);
        this.context = context;
        this.products = products;
    }

    public int getCount()
    {
        return products.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.shop_item_layout, parent, false);

        // Get shop item
        Product product = products.get(position);

        // Set name, cost and quantity
        TextView nameTextView = (TextView) rowView.findViewById(R.id.shop_item_name);
        TextView priceTextView = (TextView) rowView.findViewById(R.id.shop_item_price);
        TextView quantityTextView = (TextView) rowView.findViewById(R.id.shop_item_quantity);
        ImageView photoImageView = (ImageView) rowView.findViewById(R.id.shop_item_photo);

        nameTextView.setText(product.getName());
        photoImageView.setImageResource(mapProductToImage(product.getName()));

        if (product.getPrice() >= 0) {
            priceTextView.setText("Preço: " + product.getPrice() + " créditos");
        } else {
            priceTextView.setText("--");
        }

        if (product.getQuantity() >= 0) {
            quantityTextView.setText("Quantidade: " + product.getQuantity() + " " + product.getUnits());
        } else {
            quantityTextView.setText("--");
        }

        return rowView;
    }

    private int mapProductToImage(String name) {

        switch (name) {
            case "Anilhas A":
            case "Anilhas B":
            case "Anilhas C":
            case "Anilhas D":
            case "Anilhas E":
            case "Anilhas F":
                return R.drawable.anilhas;
            case "Balões":
                return R.drawable.baloes;
            case "Berlindes":
                return R.drawable.berlindes;
            case "Bobinas (costura)":
                return R.drawable.bobinascostura;
            case "Braçadeiras grandes":
            case "Braçadeiras médias":
            case "Braçadeiras pequenas":
                return R.drawable.bracadeiras;
            case "Buzzers":
                return R.drawable.buzzer;
            case "Caixa de ovos":
                return R.drawable.caixasovos;
            case "Camarões A":
            case "Camarões B":
            case "Camarões C":
                return R.drawable.camaroes;
            case "Cantoneiras de cartão":
                return R.drawable.cantoneiracartao;
            case "Cilindros de plástico":
                return R.drawable.cilindrosplastico;
            case "Conectores para pilha":
                return R.drawable.conetorespilha;
            case "Copos de shot":
                return R.drawable.coposhot;
            case "Cordel azul nylon":
            case "Cordel vermelho nylon":
                return R.drawable.cordelnylon;
            case "Dobradiças grandes":
            case "Dobradiças pequenas":
                return R.drawable.dobradicas;
            case "Elásticos":
                return R.drawable.elasticos;
            case "Fio amarelo":
            case "Fio azul":
            case "Fio branco":
            case "Fio laranja":
            case "Fio verde":
                return R.drawable.fiocor;
            case "Fio de pesca":
                return R.drawable.fiopesca;
            case "Fio elétrico":
                return R.drawable.fioeletrico;
            case "Folha de alumínio":
                return R.drawable.folhaluminio;
            case "Frascos de vidro":
                return R.drawable.frascovidro;
            case "Fósforos":
                return R.drawable.fosforos;
            case "Laser":
                return R.drawable.laser;
            case "LDR":
                return R.drawable.ldr;
            case "LEDs amarelos":
                return R.drawable.ledamarela;
            case "LEDs brancos":
                return R.drawable.ledbranco;
            case "LEDs verdes":
                return R.drawable.ledverde;
            case "LEDs vermelhos":
                return R.drawable.ledvermelha;
            case "Lã":
                return R.drawable.la;
            case "Microswitch":
                return R.drawable.microswitch;
            case "Molas":
                return R.drawable.molas;
            case "Palhinhas":
                return R.drawable.palhinhas;
            case "Palitos espetada 1":
            case "Palitos espetada 2":
            case "Palitos espetada 3":
                return R.drawable.palitosespetada;
            case "Palitos normais":
                return R.drawable.palitos;
            case "Papelão":
                return R.drawable.papelao;
            case "Parafusos A":
            case "Parafusos B":
            case "Parafusos C":
            case "Parafusos D":
            case "Parafusos E":
            case "Parafusos F":
            case "Parafusos G":
            case "Parafusos H":
            case "Parafusos I":
            case "Parafusos J":
            case "Parafusos L":
            case "Parafusos M":
            case "Parafusos N":
            case "Parafusos O":
            case "Parafusos P":
                return R.drawable.parafusos;
            case "Película aderente":
                return R.drawable.peliculaderente;
            case "Peças de dominó":
                return R.drawable.pecasdomino;
            case "Pilhas 9V":
                return R.drawable.pilhas9v;
            case "Pilhas AA 1.5V":
                return R.drawable.pilhasaa15v;
            case "Pilhas AAA 1.5V":
                return R.drawable.pilhasaaa15v;
            case "Pioneses":
                return R.drawable.pioneses;
            case "Plasticina":
                return R.drawable.plasticina;
            case "Porcas":
                return R.drawable.porcas;
            case "Prego Tipo 1":
            case "Prego Tipo 2":
            case "Prego Tipo 3":
            case "Prego Tipo 4":
            case "Prego Tipo 5 (40 mm)":
            case "Prego Tipo 6 (60 mm)":
            case "Prego Tipo 7":
            case "Prego Tipo 8":
                return R.drawable.prego;
            case "Resistências":
                return R.drawable.resistencias;
            case "Rodas de metal":
                return R.drawable.rodasmetal;
            case "Rodas de plástico":
                return R.drawable.rodasplastico;
            case "Roldanas":
                return R.drawable.roldanas;
            case "Rolhas de cortiça":
                return R.drawable.rolhascortica;
            case "Roofmate grande":
            case "Roofmate médio":
            case "Roofmate pequeno":
                return R.drawable.roofmate;
            case "Seringas Tipo A":
                return R.drawable.seringastipoa;
            case "Seringas Tipo B":
                return R.drawable.seringastipob;
            case "Seringas Tipo C":
                return R.drawable.seringastipoc;
            case "Seringas Tipo D":
                return R.drawable.seringastipod;
            case "Seringas Tipo E":
                return R.drawable.seringastipoe;
            case "Switch":
                return R.drawable.sw;
            case "Tampas de plástico":
                return R.drawable.tampasplastico;
            case "Transístor NPN":
            case "Transístor PNP":
                return R.drawable.transistorespnp;
            case "Tubos cartão 1":
            case "Tubos cartão 2":
            case "Tubos cartão 3":
            case "Tubos cartão 4":
                return R.drawable.tuboscartao;
            case "Tubos PVC 1":
            case "Tubos PVC 2":
                return R.drawable.tubospvc;
            case "Velas compridas":
                return R.drawable.velascompridas;
            case "Velas pequenas":
                return R.drawable.velaspequenas;
            case "Ventoinhas":
                return R.drawable.ventoinha;
            default:
                return R.drawable.icon_foto;

        }
    }
}

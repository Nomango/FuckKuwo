package cn.nomango.FuckKuwo.controller;

import cn.nomango.FuckKuwo.tools.Base64Coder;
import cn.nomango.FuckKuwo.tools.KuwoDES;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea txtData;
    @FXML
    private TextField txtKey;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnEncrypt;
    @FXML
    private Button btnDecrypt;

    private static final String HOST = "http://comment.kuwo.cn/com.s?f=ar&q=";

    public void initialize() {
    }

    public void onBtnEncryptClick() {
        try {
            byte[] data = txtData.getText().getBytes();
            byte[] key = txtKey.getText().getBytes();
            byte[] encryptParameters = KuwoDES.encryptKSing(data, key);
            String b64Params = new String(Base64Coder.encode(encryptParameters, encryptParameters.length));

            txtResult.setText(HOST + b64Params);
        } catch (Exception e) {
            txtResult.setText(e.getMessage());
        }
    }

    public void onBtnDecryptClick() {
        try {
            byte[] b64Data = Base64Coder.decode(txtData.getText());
            String key = txtKey.getText();
            String str = new String((KuwoDES.decryptKSing(b64Data, key.getBytes()))).trim();
            txtResult.setText(str);
        } catch (Exception e) {
            txtResult.setText(e.getMessage());
        }
    }
}

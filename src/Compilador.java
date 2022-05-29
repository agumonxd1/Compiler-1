
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Compilador UMG";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".mlp");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(255, 102, 0));

        buttonsFilePanel.setBackground(new java.awt.Color(255, 102, 0));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jtpCode);

        panelButtonCompilerExecute.setBackground(new java.awt.Color(255, 102, 0));

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        label1.setText("Compiladores");

        label2.setText("Universidad Mariano Gálvez de Guatemala");

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                        .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);

        /**Eliminación de errores**/
        gramatica.delete(new String[]{"ERROR","ERROR1"},1);
        
        /*Suma de variables y valores*/
        gramatica.group("OPERACION_NUM","NUMERO OPERADOR_ARITMETICO NUMERO",true);
        gramatica.group("OPERACION_VAR","VARIABLE OPERADOR_ARITMETICO VARIABLE",true);
        gramatica.group("OPERACION_VAR","VARIABLE OPERADOR_ARITMETICO NUMERO",true);
        gramatica.group("OPERACION_VAR","NUMERO OPERADOR_ARITMETICO VARIABLE",true);
        gramatica.group("ERROR_OPERACION_VAR","IDENTIFICADOR OPERADOR_ARITMETICO IDENTIFICADOR", true,
                17,"ERROR SINTÁCTICO {}, NO SE PUEDEN OPERAR IDENTIFICADORES [#,%]");
        gramatica.group("ERROR_OPERACION_VAR","IDENTIFICADOR OPERADOR_ARITMETICO VARIABLE", true,
                18,"ERROR SINTÁCTICO {}, NO SE PUEDEN OPERAR IDENTIFICADORES [#,%]");
        gramatica.group("ERROR_OPERACION_VAR","VARIABLE OPERADOR_ARITMETICO IDENTIFICADOR", true,
                19,"ERROR SINTÁCTICO {}, NO SE PUEDEN OPERAR IDENTIFICADORES [#,%]");
        
        gramatica.group("OPERACION_VAR_EXPR","EXPRESION OPERACION_VAR", true);
        gramatica.group("VAR_ERROR","CORCHETE_A OPERACION_VAR CORCHETE_C",true,
                16,"ERROR SINTÁCTICO {}, SE ESPERABA LA DECLARACIÓN EXPRESION [#,%]");
        gramatica.group("VAR_ERROR","LLAVE_A OPERACION_VAR CORCHETE_C",true,
                15,"ERROR SINTÁCTICO {}, UTILIZACIÓN DE AGRUPADORES INCORRECTA [#,%]");
        gramatica.group("VAR_ERROR","CORCHETE_A OPERACION_VAR LLAVE_C",true,
                14,"ERROR SINTÁCTICO {}, UTILIZACIÓN DE AGRUPADORES INCORRECTA [#,%]");
        gramatica.group("OPERACION_VAR_A","CORCHETE_A OPERACION_VAR_EXPR CORCHETE_C", true);
        gramatica.group("VAR_ERROR","LLAVE_A OPERACION_VAR_EXPR LLAVE_C",true,
                13,"ERROR SINTÁCTICO {}, SE ESPERABAN CORCHETES COMO SIGNOS DE AGRUPACIÓN [#,%]");
        
        /*Declaración de variables*/
        gramatica.group("VARC","(OPERADOR_ASIGNACION IDENTIFICADOR OPERACION_VAR_A)",true);
        gramatica.group("VAR_ERROR","IDENTIFICADOR IDENTIFICADOR OPERACION_VAR_A",true,
                18,"ERROR SINTÁCTICO {}, SE ESPERABA UN OPERADOR DE ASIGNACIÓN [#,%]");
        gramatica.group("VAR","(OPERADOR_ASIGNACION IDENTIFICADOR NUMERO)", true);
        gramatica.group("VAR","(OPERADOR_ASIGNACION IDENTIFICADOR STRING)", true);
        gramatica.group("VAR_ERROR","IDENTIFICADOR IDENTIFICADOR NUMERO", true,
                3,"ERROR SINTÁCTICO, SE ESPERABA LA ASIGNACIÓN DE UN VALOR [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("VAR_ERROR","IDENTIFICADOR IDENTIFICADOR IDENTIFICADOR", true,
                4,"ERROR SINTÁCTICO, SE ESPERABA UNA DECLARACIÓN O UNA ASIGNACIÓN [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("VAR_ERROR","IDENTIFICADOR IDENTIFICADOR NUMERO", true,
                5,"ERROR SINTÁCTICO, SE ESPERABA LA ASIGNACIÓN DE UN VALOR [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("VAR_ERROR","IDENTIFICADOR NUMERO",true,
                6,"ERROR SINTÁCTICO, SE ESPERABA UNA DECLARACIÓN DEL IDENTIFICADOR O UNA ASIGNACIÓN DE VALOR [#,%]");
        gramatica.finalLineColumn();
        /*Impresion de datos por la función puts*/
        gramatica.group("IMPRESION_DATOS","IMPRIMIR NUMERO", true);
        gramatica.group("IMPRESION_DATOS","IMPRIMIR STRING", true);
        gramatica.group("IMPRESION_DATOS","IMPRIMIR VARIABLE", true);
        gramatica.group("IMPRESION_ERROR","IMPRIMIR IMPRIMIR", true,
                7,"ERROR SINTÁCTICO {}, DECLARACIÓN DE COMANDO DE IMPRESIÓN INCORRECTO [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("IMPRESION_ERROR","IMPRIMIR IDENTIFICADOR", true,
                8,"ERROR SINTÁCTICO {}, NO SE PUEDE IMPRIMIR UN IDENTIFICADOR [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("IMPRESION_ERROR","IMPRIMIR OPERADOR_ASIGNACION", true,
                9,"ERROR SINTÁCTICO {}, SE ESPERABA UNA IMPRESIÓN DE DATOS O UNA ASIGNACIÓN DE VALOR [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("IMPRESION_ERROR","IMPRIMIR IMPRIMIR", true,
                10,"ERROR SINTÁCTICO {}, SE ESPERABA UN VALOR PARA IMPRIMIR [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("IMPRESION_ERROR","IMPRIMIR IDENTIFICADOR", true,
                11,"ERROR SINTÁCTICO {}, NO SE PUEDE IMPRIMIR UN IDENTIFICADOR [#,%]");
        gramatica.finalLineColumn();
        
        gramatica.group("IMPRESION_ERROR","IMPRIMIR IDENTIFICADOR", true,
                12,"ERROR SINTÁCTICO {}, NO SE PUEDE IMPRIMIR UN IDENTIFICADOR [#,%]");
        gramatica.finalLineColumn();
        
                /*---------Sentencia IF---------*/
        /*Comparacion*/
        gramatica.group("COMP","NUMERO OPERADOR_RELACIONAL NUMERO",true);
        gramatica.group("COMP","VARIABLE OPERADOR_RELACIONAL NUMERO",true);
        gramatica.group("COMP","NUMERO OPERADOR_RELACIONAL VARIABLE",true);
        gramatica.group("COMP","VARIABLE OPERADOR_RELACIONAL VARIABLE",true);
        gramatica.group("ERROR_COMP","IDENTIFICADOR OPERADOR_RELACIONAL IDENTIFICADOR",true,
                20,"ERROR SINTÁCTICO {}, NO SE PUEDEN COMPARAR IDENTIFICADORES [#,%]");
        gramatica.group("ERROR_COMP","IDENTIFICADOR OPERADOR_RELACIONAL NUMERO",true,
                20,"ERROR SINTÁCTICO {}, NO SE PUEDEN COMPARAR IDENTIFICADORES [#,%]");
        gramatica.group("ERROR_COMP","NUMERO OPERADOR_RELACIONAL IDENTIFICADOR",true,
                20,"ERROR SINTÁCTICO {}, NO SE PUEDEN COMPARAR IDENTIFICADORES [#,%]");
        gramatica.group("ERROR_COMP","IDENTIFICADOR OPERADOR_RELACIONAL VARIABLE",true,
                20,"ERROR SINTÁCTICO {}, NO SE PUEDEN COMPARAR IDENTIFICADORES [#,%]");
        gramatica.group("ERROR_COMP","VARIABLE OPERADOR_RELACIONAL IDENTIFICADOR",true,
                20,"ERROR SINTÁCTICO {}, NO SE PUEDEN COMPARAR IDENTIFICADORES [#,%]");
        /*Agrupación de comparaciones*/
        gramatica.group("COMP_AG","LLAVE_A COMP LLAVE_C",true);
        gramatica.group("ERROR_COMP_AG","COMP LLAVE_C",true,
                21,"ERROR SINTÁCTICO {}, SE ESPERABA UNA LLAVE DE APERTURA [#,%]");
        gramatica.group("ERROR_COMP_AG","LLAVE_A COMP",true,
                21,"ERROR SINTÁCTICO {}, SE ESPERABA UNA LLAVE DE CIERRE [#,%]");
        gramatica.group("ERROR_COMP_AG","CORCHETE_A COMP CORCHETE_C",true,
                21,"ERROR SINTÁCTICO {}, SE UTILIZÓ UN AGRUPADOR INCORRECTO [#,%]");
        gramatica.group("ERROR_COMP_AG","CORCHETE_A COMP LLAVE_C",true,
                21,"ERROR SINTÁCTICO {}, SE UTILIZÓ UN AGRUPADOR INCORRECTO [#,%]");
        gramatica.group("ERROR_COMP_AG","LLAVE_A COMP CORCHETE_C",true,
                21,"ERROR SINTÁCTICO {}, SE UTILIZÓ UN AGRUPADOR INCORRECTO [#,%]");
        
        /*Asignación de comparaciones a estructuras*/
        gramatica.group("COMP_ESTRUC","(IF | WHILE) COMP_AG",true);
        gramatica.group("COMP_ESTRUC_ERROR","COMP_AG (IF | WHILE)",true,
                22,"ERROR SINTÁCTIVO {}, LA DECLARACIÓN DE LA ESTRUCTURA NO ES CORRECTA [#,%]");
        
        /*Declaración de cuerpos para estructuras*/
        gramatica.group("CUERPO","(NUMERO | OPERACION_VAR_A)",true);
        
        /*Apertura y cierre de estructuras*/
        gramatica.group("COMP_ESTRUC_AG","COMP_ESTRUC LLAVE_A CUERPO LLAVE_C",true);
        
        /*Declaración de estructura Switch*/
        gramatica.group("ESTRUC_SW","SWITCH (OPERACION_NUM | OPERACION_VAR | VARIABLE | NUMERO)",true);
        gramatica.group("ESTRUC_SW_ERROR","(OPERACION_NUM | OPERACION_VAR | VARIABLE | NUMERO) SWITCH",true,
                23,"ERROR SINTÁCTICO {}, LA DECLARACIÓN DE LA ESTRUCTURA NO ES CORRECTA [#,%]");
        gramatica.group("ESTRUC_SW_ERROR","SWITCH IDENTIFICADOR",true,
                24,"ERROR SINTÁCTICO {}, NO SE PUEDE EVALUAR UN IDENTIFICADOR [#,%]");
      
        gramatica.group("INT_SW","(VARIABLE | IMPRESION_DATOS)",true);
        gramatica.group("CUERPO_SW","(VARIABLE | NUMERO | STRING) LLAVE_A INT_SW LLAVE_C",true);
        gramatica.group("ESTRUC_SW_AG","ESTRUC_SW LLAVE_A CUERPO_SW LLAVE_C",true);
        gramatica.group("ESTRUC_SW_AG_ERROR","ESTRUC_SW CUERPO_SW LLAVE_C",true,
                25,"ERROR SINTÁCTICO {}, SE ESPERABA UNA LLAVE DE APERTURA [#,%]");
        gramatica.group("ESTRUC_SW_AG_ERROR","ESTRUC_SW HLLAVE_A CUERPO_SW",true,
                25,"ERROR SINTÁCTICO {}, SE ESPERABA UNA LLAVE DE CIERRE [#,%]");
       
        
        
        /* Eliminación de tipos de dao y operadores de asignación*/
        gramatica.delete("TIPODATO",99,
                "ERROR SINTÁCTICO {}, EL TIPO DE DATO NO SE ENCUENTRA EN UNA DECLARACIÓN [#,%]");
        
        /*Agrupación de identificadores y definición de parpametros*/
        gramatica.group("VALOR", "IDENTIFICADOR",true);
        
        
        gramatica.show();
    }

    private void semanticAnalysis() {
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}

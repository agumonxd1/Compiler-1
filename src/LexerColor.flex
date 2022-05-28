import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
/* ComentarioSharp */
ComentarioSharp = \#{Letra}({Letra}|{Digito}|["\\s+", "   "])*
String = \"([0-9a-zA-ZáéíñóúüÁÉÍÑÓÚÜ_-]|["\\s+", "   "])*\"
%%

/* Comentarios o espacios en blanco */

/*Default*/
"default" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
/*Comentario Sharp*/
{ComentarioSharp} { return textColor(yychar, yylength(), new Color(140, 140, 140)); }

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco}|{ComentarioSharp} { /*Ignorar*/ }

/* Exp Entero */
{Numero} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Operadores de agrupación */
"[" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
"]" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
"{" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
"}" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Operador de asignación */
"set" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Imprimir */
"puts" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Incrementar */
"incr" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Comparadores */
"<" | ">" | "=" | "<=" | ">=" | "<>" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Operadores */
"+" | "-" | "*" | "/" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Estructuras */
/* For */
"for" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Switch */
"switch" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* STRING */
{String} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Expresion */
"expr" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Variable */
"$"{Identificador} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Identificador */
{Identificador} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Manejo de errores */

/*Error al colocar un número*/
0{Numero} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

{EspacioEnBlanco} { /*Ignorar*/ }

. { /* Ignorar */ }
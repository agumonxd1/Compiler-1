import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
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

/*{Letra}({Letra}|{Digito}|{EspacioEnBlanco})*{TerminadorDeLinea}?*/

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* ComentarioSharp */
ComentarioSharp = \#{Letra}({Letra}|{Digito}|["\\s+", "   "])*
String = \"([0-9a-zA-ZáéíñóúüÁÉÍÑÓÚÜ_-]|["\\s+", "   "])*\"

/* Número */
Numero = 0 | [1-9][0-9]*

%%
/*Default*/
"default" {return token(yytext(), "DEFAULT", yyline, yycolumn); }
/*Comentario Sharp*/
{ComentarioSharp} {return token(yytext(), "COMENTARIO", yyline, yycolumn); }

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco}|{ComentarioSharp} { /*Ignorar*/ }

/* Exp Entero */
{Numero} { return token(yytext(), "NUMERO", yyline, yycolumn); }

/* Operadores de agrupación */
"[" { return token(yytext(), "CORCHETE_A", yyline, yycolumn); }
"]" { return token(yytext(), "CORCHETE_C", yyline, yycolumn); }
"{" { return token(yytext(), "LLAVE_A", yyline, yycolumn); }
"}" { return token(yytext(), "LLAVE_C", yyline, yycolumn); }

/* Operador de asignación */
"set" { return token(yytext(), "OPERADOR_ASIGNACION", yyline, yycolumn); }

/* Imprimir */
"puts" { return token(yytext(), "IMPRIMIR", yyline, yycolumn); }

/* Incrementar */
"incr" { return token(yytext(), "INCREMENTAR", yyline, yycolumn); }

/* Operadores Aritméticos */
"*"|"/"|"%"|"+"|"-" {return token(yytext(), "OPERADOR_ARITMETICO", yyline, yycolumn); }

/* Estructuras */
/* For */
"for" { return token(yytext(), "FOR", yyline, yycolumn); }

/* Switch */
"switch" { return token(yytext(), "SWITCH", yyline, yycolumn); }

/* Estructura IF THEN ELSEIF ELSE */
if {return token(yytext(), "IF", yyline, yycolumn); }
then {return token(yytext(), "THEN", yyline, yycolumn); }
elseif {return token(yytext(), "ELSEIF", yyline, yycolumn); }
else {return token(yytext(), "ELSE", yyline, yycolumn); }

/* Ciclo While */
while {return token(yytext(), "WHILE", yyline, yycolumn); }
continue {return token(yytext(), "CONTINUE", yyline, yycolumn); }
break {return token(yytext(), "BREAK", yyline, yycolumn); }

/* Procedimientos */
proc {return token(yytext(), "PROC", yyline, yycolumn); }
return {return token(yytext(), "RETURN", yyline, yycolumn); }

/* STRING */
{String} { return token(yytext(), "STRING", yyline, yycolumn); }

/* Expresion */
"expr" { return token(yytext(), "EXPRESION", yyline, yycolumn); }

/* Variable */
"$"{Identificador} {return token(yytext(), "VARIABLE", yyline, yycolumn); }

/* Operadores relacionales para cadenas */
eq | ne | in | ni {return token(yytext(), "OPERADOR_RELACIONAL_C", yyline, yycolumn); }

/* Operadores lógicos */
"&&" | "||" | "!" {return token(yytext(), "OPERADOR_LOGICO", yyline, yycolumn); }

/* Operadores relacionales */
"<" | ">" | "==" | "<=" | ">=" | "<>" { return token(yytext(), "OPERADOR_RELACIONAL", yyline, yycolumn);}

/* Operadores Unarios*/
"+"{Numero} | "-"{Numero} {Identificador} {return token(yytext(), "OPERADOR_UNARIO", yyline, yycolumn); }

/* Exponente */
"**" {return token(yytext(), "EXPONENTE", yyline, yycolumn); }



/* Identificador */
{Identificador} {return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

/* Manejo de errores */

/*Error al colocar un número*/
0{Numero} {return token(yytext(), "ERROR1", yyline, yycolumn); }



. { return token(yytext(), "ERROR", yyline, yycolumn); }


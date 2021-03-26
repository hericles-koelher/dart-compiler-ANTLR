SRC_DIR=src
CLASS_DIR=$(SRC_DIR)/Classes
ANTLR4=tools/antlr-4.9.1-complete.jar
PACKAGE=Dart

all: Classes

#Criação dos arquivos .class
Classes: Dart
	javac -d $(CLASS_DIR) -cp $(ANTLR4) $(SRC_DIR)/AST/*.java $(SRC_DIR)/$(PACKAGE)/*.java $(SRC_DIR)/Types/*.java $(SRC_DIR)/SymbolTable/*.java $(SRC_DIR)/Main.java

#Codigo do Scanner+Parser
Dart:
	java -jar $(ANTLR4) -visitor -no-listener -package $(PACKAGE) -o $(SRC_DIR)/$(PACKAGE) -Xexact-output-dir $(SRC_DIR)/Dart.g4

clean:
	rm -rf $(CLASS_DIR)

#Testes

run:
	java -cp $(CLASS_DIR):$(ANTLR4) Main dart_sample_code/correct/1.dart

func:
	java -cp $(CLASS_DIR):$(ANTLR4) Main dart_sample_code/correct/functions.dart

test_c:
	@echo "Testing correct sample:\n"
	@for file in dart_sample_code/correct/*; do\
		echo $$file;\
		java -cp $(CLASS_DIR):$(ANTLR4) Main $$file;\
		echo "\n";\
	done

test_err:
	@echo "Testing incorrect sample:\n"
	@for file in dart_sample_code/incorrect/*; do\
		echo $$file;\
		java -cp $(CLASS_DIR):$(ANTLR4) Main $$file;\
		echo "\n";\
	done
SRC_DIR=src
OUT_DIR=out
CLASS_DIR=$(SRC_DIR)/Classes
MAIN=Main.java
ANTLR4=tools/antlr-4.9.1-complete.jar
PACKAGE_NAME=AutoGeneratedCode

all: Classes

#Criação dos arquivos .class
Classes: AutoGeneratedCode
	javac -d $(CLASS_DIR) -cp $(ANTLR4) $(SRC_DIR)/*.java $(SRC_DIR)/$(MAIN)

#Codigo do Scanner+Parser
AutoGeneratedCode:
	java -jar $(ANTLR4) -visitor $(SRC_DIR)/Dart.g4

clean:
	rm -rf $(CLASS_DIR)

#Testes

run:
	java -cp $(CLASS_DIR):$(ANTLR4) Main dart_sample_code/correct/4.dart

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
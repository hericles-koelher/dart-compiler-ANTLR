SRC_DIR=src
CLASS_DIR=$(SRC_DIR)/Classes
ANTLR4=tools/antlr-4.9.1-complete.jar
ASM=tools/asm-9.1.jar
PACKAGE=Dart
PACKAGE_DIR=$(SRC_DIR)/$(PACKAGE)
JAVA_FILES=$(shell find -name "*.java")

all: Classes

#Criação dos arquivos .class
Classes: Dart
	javac -d $(CLASS_DIR) -cp $(ANTLR4) $(JAVA_FILES)

#Codigo do Scanner+Parser
Dart:
	java -jar $(ANTLR4) -visitor -package $(PACKAGE) -o $(PACKAGE_DIR) -Xexact-output-dir $(SRC_DIR)/Dart.g4

clean:
	rm -rf $(CLASS_DIR)

#Testes

run:
	java -cp $(CLASS_DIR):$(ANTLR4) Main dart_sample_code/correct/4.dart
	dot -Tpdf ast1.dot -o ast1.pdf

# test_c:
# 	@echo "Testing correct sample:\n"
# 	@for file in dart_sample_code/correct/*; do\
# 		echo $$file;\
# 		java -cp $(CLASS_DIR):$(ANTLR4) Main $$file;\
# 		echo "\n";\
# 	done
#
# test_err:
# 	@echo "Testing incorrect sample:\n"
# 	@for file in dart_sample_code/incorrect/*; do\
# 		echo $$file;\
# 		java -cp $(CLASS_DIR):$(ANTLR4) Main $$file;\
# 		echo "\n";\
# 	done
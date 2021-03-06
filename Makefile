SOURCE = ./src/

S_MODELS      = $(SOURCE)models/
S_VIEWS       = $(SOURCE)views/
S_CONTROLLERS = $(SOURCE)controllers/

BUILD = ./class/

B_MODELS      = $(BUILD)models/
B_VIEWS       = $(BUILD)views/
B_CONTROLLERS = $(BUILD)controllers/


JC = javac
JCFLAGS = --release 8 -encoding UTF-8 -d $(BUILD) -implicit:none -sourcepath "$(SOURCE)" -classpath "$(BUILD)"

JVM = java


CLASSES = $(B_CONTROLLERS)Main.class \
          \
          $(B_MODELS)Board.class \
          $(B_MODELS)Square.class \
          $(B_MODELS)Chessman.class \
          $(B_MODELS)King.class \
          $(B_MODELS)Queen.class \
          $(B_MODELS)Rook.class \
          $(B_MODELS)Bishop.class \
          $(B_MODELS)Knight.class \
          $(B_MODELS)Pawn.class \
          \
          $(B_VIEWS)Window.class \
          $(B_VIEWS)Chess.class \
          $(B_VIEWS)Cell.class \
          \
          $(B_CONTROLLERS)Move.class


all: $(B_CONTROLLERS)Main.class

$(B_CONTROLLERS)Main.class: $(S_CONTROLLERS)Main.java \
                            $(B_VIEWS)Chess.class
	$(JC) $(JCFLAGS) $<

$(B_MODELS)Board.class: $(S_MODELS)Board.java \
                        $(B_MODELS)Square.class \
                        $(B_MODELS)King.class \
                        $(B_MODELS)Queen.class \
                        $(B_MODELS)Rook.class \
                        $(B_MODELS)Bishop.class \
                        $(B_MODELS)Knight.class \
                        $(B_MODELS)Pawn.class \
                        $(B_VIEWS)Cell.class
	$(JC) $(JCFLAGS) $<

$(B_MODELS)Square.class: $(S_MODELS)Square.java \
                         $(B_MODELS)Chessman.class
	$(JC) $(JCFLAGS) $<

$(B_MODELS)Chessman.class: $(S_MODELS)Chessman.java \
                           $(S_MODELS)Square.java
	$(JC) $(JCFLAGS) $<

$(B_MODELS)King.class: $(S_MODELS)King.java \
                       $(B_MODELS)Chessman.class
	$(JC) $(JCFLAGS) $<

$(B_MODELS)Queen.class: $(S_MODELS)Queen.java \
                        $(B_MODELS)Chessman.class
	$(JC) $(JCFLAGS) $<

$(B_MODELS)Rook.class: $(S_MODELS)Rook.java \
                       $(B_MODELS)Chessman.class
	$(JC) $(JCFLAGS) $<

$(B_MODELS)Bishop.class: $(S_MODELS)Bishop.java \
                         $(B_MODELS)Chessman.class
	$(JC) $(JCFLAGS) $<

$(B_MODELS)Knight.class: $(S_MODELS)Knight.java \
                         $(B_MODELS)Chessman.class
	$(JC) $(JCFLAGS) $<

$(B_MODELS)Pawn.class: $(S_MODELS)Pawn.java \
                       $(B_MODELS)Chessman.class
	$(JC) $(JCFLAGS) $<

$(B_VIEWS)Window.class: $(S_VIEWS)Window.java
	$(JC) $(JCFLAGS) $<

$(B_VIEWS)Chess.class: $(S_VIEWS)Chess.java \
                       $(B_MODELS)Board.class \
                       $(B_VIEWS)Window.class \
                       $(B_CONTROLLERS)Move.class
	$(JC) $(JCFLAGS) $<

$(B_VIEWS)Cell.class: $(S_VIEWS)Cell.java \
                      $(B_MODELS)Square.class
	$(JC) $(JCFLAGS) $<

$(B_CONTROLLERS)Move.class: $(S_CONTROLLERS)Move.java \
                            $(B_MODELS)Board.class \
                            $(B_MODELS)Square.class \
                            $(B_VIEWS)Cell.class
	$(JC) $(JCFLAGS) $<


run: all
	cd $(BUILD) && $(JVM) controllers.Main

clean:
	rm -f $(CLASSES)

.PHONY: all \
        run \
        clean

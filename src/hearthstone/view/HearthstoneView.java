package hearthstone.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;























import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;







import engine.Game;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Warlock;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


import engine.GameListener;
import exceptions.*;
import model.cards.*;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Spell;
import model.heroes.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.SetChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HearthstoneView extends Application implements GameListener{

	private Scene IntroScene, PreMainMenuScene, MainMenuScene, OptionsScene ,Player1MenuScene, Player2MenuScene;
	
	private ImageView IntroGifView, preMainMenuView ,StartButtonView, BackButton1View,
	
	MainMenuView, BackButton2View, NewGameButtonView, QuitGameButtonView, OptionsButtonView,
	
	Player1MenuView, Player2MenuView,
	
	 BackButton3View,
	
	// For Player1 Menu
	JainaMiniView, RexxarMiniView, UtherLightbringerMiniView, GuldanMiniView, AnduinWrynnMiniView,
	JainaProudmooreView, RexxarView, UtherLightbringerView, GuldanView, AnduinWrynnView,
	
	QuestionMarkView, QuestionMarkView2,
	
	JainaLabelView, RexxarLabelView, GuldanLabelView, UtherLabelView, AnduinLabelView,
	JainaReviewView, RexxarReviewView, GuldanReviewView, UtherReviewView, AnduinReviewView, CloseXView,
	
	// For Player2 Menu
	
	JainaMiniView2, RexxarMiniView2, UtherLightbringerMiniView2, GuldanMiniView2, AnduinWrynnMiniView2, selectView, selectView2,
	JainaProudmooreView2, RexxarView2, UtherLightbringerView2, GuldanView2, AnduinWrynnView2,
	
	QuestionMarkView3, QuestionMarkView4, BackButton4View, RestartAnotherMatchView,
	
	JainaLabelView2, RexxarLabelView2, GuldanLabelView2, UtherLabelView2, AnduinLabelView2,
	JainaReviewView2, RexxarReviewView2, GuldanReviewView2, UtherReviewView2, AnduinReviewView2, CloseXView2,
	SelectYourTargetImageView, CancelAttackImageView, pic;
	
	private boolean JainaCheck, RexxarCheck, GuldanCheck, UtherCheck, AnduinCheck, ReviewCheck = false;
	
	private boolean JainaCheck2, RexxarCheck2, GuldanCheck2, UtherCheck2, AnduinCheck2, ReviewCheck2 = false;
	
	private FadeTransition ReviewTransition, ReviewTransition2;
	
	private TextField Player1Name, Player2Name;
	
	private AnchorPane layout1 ,layout2, layout3, layout4, layout5, layout6;
	
	private String Hero1Name, Hero2Name;
	
	// Andrew's Initializations
	private AnchorPane window, Hero1, Hero2, hero, Hero1p, Hero2p, herop;
	
	private Screen screen;
	
	private Scene scene;
	
	private AnchorPane card1, card2, newC, Back, BackCard, End;
	
	private Label atkF, manaF, hpF, FullMana, Hero1mana, Hero2mana, Mana1, Mana2, Mana, 
	HeroHealth1, HeroHealth2, HeroHealth;
	
	private IntegerProperty manapts,mana,hppts,hp,atkpts,atk,CMana,CManaB,TMana,TManaB,HeroHP,HeroHPB;
	
	private HBox p1hand, p2hand, p1field, p2field, p1Backs, p2Backs;
	
	private Hero player1, player2; 
	
	private Game game;
	
	private Node Selected1, Selected1d, Selected2, Selected2d;
	
	private AlertBox alert;
	
	private Card Attacker;
	
	private ImageView Hero1BigView, Hero2BigView;

    private Label Hero1LabelView, Hero2LabelView;
    
    private Glow glow, glowAndShadow;
    
    private DropShadow borderGlow, borderGlowHigh;
    
    private AnchorPane Attacking, Defending;
    
    private boolean attacking, power, JainaPower1, JainaPower2, AnduinPower1, AnduinPower2;
    
    private boolean PolymorphedLegend = false;
    
    private Card attacker;
    
    private ColorAdjust colorAdjust;
    
    private Timeline timeline, timeline2, timeline3, timeline4, timeline5, timeline6;
    
    private KeyValue kv, kv2, kv3, kv4, kv5, kv6;
    
    private KeyFrame kf, kf2, kf3, kf4, kf5, kf6;
    
    private Image winner, transparent, playAgain, Quit;
    
    private ImageView winnerView, transparentView, playAgainView, QuitView, OptionsMenuView, GuideView, QuitGameButtonView2;
    
    private Label winnerName, P1name, P2name;
    
    private Image P1Deck, P2Deck, Pause;
    
    private ImageView P1DeckView, P2DeckView, PauseView, CheckBoxView, CheckBoxView2, TickView, TickView2, ContinueButtonView,
    HowToPlayButtonView, CheckListView, MenuGuideView, NextButtonView, HowToPlayView1, HowToPlayView2,
    CloseHowToPlayView, PreviousButtonView, ManaImageView, ManaImageView2;
    
    private Label P1deck, P2deck;
    
    private boolean Music=true, SFX = true, overtime = false, OT1 = false, OT2 = false;
    
    private AudioClip MainMenuMusic, DuelMusic, OverTimeMusic, GameOverMusic;
    
    private AudioClip AttackOn, AttackOff, AttackDone, SpellCast, Summon, Draw,attackSound, summonSound;
    
    private AudioClip AttackedClip1, DeathClip1, EntranceClip1, FieldClip1, LowCardsClip1,OutOfCardsClip1, ManaClip1,
    				  PowerClip1, SleepingClip1, TauntClip1, ThreatenClip1, HandClip1, InvalidClip1;
    
    private AudioClip AttackedClip2, DeathClip2, EntranceClip2, FieldClip2, LowCardsClip2,OutOfCardsClip2, ManaClip2,
    				  PowerClip2, SleepingClip2, TauntClip2, ThreatenClip2, HandClip2, InvalidClip2;
    
    private AudioClip MouseClick;
    
    private Boolean deckAlert1 = false, deckAlert2 = false,threaten1 = false, threaten2 = false, outOfCards1 = false, outOfCards2=false;
	public static void main(String[]args){
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Hearthstone");
		primaryStage.setOnCloseRequest(e ->{
			e.consume();
			primaryStage.close();
		});	
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setFullScreenExitHint("");
		
		//Setting effects to be used later
		
		glow = new Glow();
		glow.setLevel(0.3);
		
		glowAndShadow = new Glow();
		glow.setLevel(0.3);
		
		borderGlow = new DropShadow();
		borderGlow.setOffsetY(0f);
		borderGlow.setOffsetX(0f);
		borderGlow.setColor(Color.GOLD);
		borderGlow.setWidth(50);
		borderGlow.setHeight(50);
		
		glowAndShadow.setInput(borderGlow);
		
		borderGlowHigh= new DropShadow();
		borderGlowHigh.setOffsetY(0f);
		borderGlowHigh.setOffsetX(0f);
		borderGlowHigh.setColor(Color.GOLD);
		borderGlowHigh.setWidth(150);
		borderGlowHigh.setHeight(150);
		
		
		colorAdjust = new ColorAdjust();
	    colorAdjust.setBrightness(-0.2);
		
		// Setting Layout1 and Intro scene
		
		layout1 = new AnchorPane();
		layout1.styleProperty().set("-fx-background-color: black;");
		IntroScene = new Scene(layout1, 500, 320, Color.BLACK);
		Image IntroGif = new Image("file:Images/IntroFinal.gif");
		IntroGifView = new ImageView(IntroGif);
		IntroGifView.setX(-20);
		
		layout1.getChildren().add(IntroGifView);
		primaryStage.setScene(IntroScene);
		
		// Setting layout 2
		
		
		layout2 = new AnchorPane();	
		layout2.styleProperty().set("-fx-background-color: black;");
		PreMainMenuScene = new Scene(layout2, 1980,1080,Color.BLACK);
		
		FadeTransition Layout2Transition = new FadeTransition(Duration.seconds(0.8), layout2);
		Layout2Transition.setFromValue(0.0);
		Layout2Transition.setToValue(1.0);
		
		Image preMainMenuImage = new Image("file:Images/HS PreMain.jpg");
		preMainMenuView = new ImageView(preMainMenuImage);
		
		Image StartButton = new Image("file:Images/Start3.png");
		StartButtonView = new ImageView(StartButton);
		StartButtonView.setLayoutX(750);
		StartButtonView.setLayoutY(670);
		
		StartButtonView.setOnMouseEntered(e -> StartButtonView.setEffect(glowAndShadow));
		StartButtonView.setOnMouseExited(e -> StartButtonView.setEffect(null));
		
	    MainMenuMusic = new AudioClip("file:Sounds/MainMenu.wav");
		MainMenuMusic.setVolume(0.5);
		MainMenuMusic.setCycleCount(AudioClip.INDEFINITE);
		
		MouseClick = new AudioClip("file:Sounds/MouseClick.wav");
		MouseClick.setVolume(0.4);
		
	    DuelMusic = new AudioClip("file:Sounds/Duel.wav");
		DuelMusic.setVolume(0.5);
		DuelMusic.setCycleCount(AudioClip.INDEFINITE);

	    OverTimeMusic = new AudioClip("file:Sounds/OverTime.wav");
		OverTimeMusic.setVolume(0.5);
		OverTimeMusic.setCycleCount(AudioClip.INDEFINITE);
		
		GameOverMusic = new AudioClip("file:Sounds/GameOver.wav");
		GameOverMusic.setVolume(0.5);
		
	    AttackOn = new AudioClip("file:Sounds/AttackOn.wav");
		AttackOn.setVolume(0.5);
		
		AttackOff = new AudioClip("file:Sounds/AttackOff.wav");
		AttackOff.setVolume(0.5);
		
		AttackDone = new AudioClip("file:Sounds/AttackDone.wav");
		AttackDone.setVolume(0.5);
		
		Summon = new AudioClip("file:Sounds/Summon.wav");
		Summon.setVolume(0.5);
		
		Draw = new AudioClip("file:Sounds/Draw.wav");
		Draw.setVolume(0.5);
		
		SpellCast = new AudioClip("file:Sounds/SpellCast.wav");
		SpellCast.setVolume(0.5);
		
		
		
		
		
		
		IntroGifView.setOnMouseClicked(e ->{		
			primaryStage.setMaximized(true);
			primaryStage.setWidth(2000);
			primaryStage.setScene(PreMainMenuScene);
			primaryStage.setFullScreen(true);
			Layout2Transition.play();
			layout2.getChildren().addAll(preMainMenuView, StartButtonView);	
			try {
				if(Music)
				MainMenuMusic.play();		
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
			 
		}); 
					
		// Setting layout3 (The Main Menu Scene) & layout 6 (Options Menu)
		
		layout3 = new AnchorPane();
		MainMenuScene = new Scene(layout3, 1980, 1080, Color.BLACK);
		layout3.styleProperty().set("-fx-background-color: black;");
		
		Image MainMenu = new Image("file:Images/MainMenu2.png");
		MainMenuView = new ImageView(MainMenu);
		layout3.getChildren().add(MainMenuView);
		MainMenuView.setFitHeight(primaryStage.getHeight());
		MainMenuView.setFitWidth(1920);
		
		Image BackButtonImage = new Image("file:Images/BackButtonFinal.png");
		BackButton1View = new ImageView(BackButtonImage);
		layout3.getChildren().add(BackButton1View);
		BackButton1View.setX(22);
		BackButton1View.setY(20);
		
		Image MenuGuide = new Image("file:Images/MenuGuide.png");
        MenuGuideView = new ImageView(MenuGuide);
        MenuGuideView.setPreserveRatio(true);
        MenuGuideView.setX(280);
        MenuGuideView.setY(150);
        MenuGuideView.setFitWidth(1400);
        MenuGuideView.setEffect(borderGlow);
        
        Image CloseGuide = new Image("file:Images/CloseX2.png");
        ImageView CloseGuideView = new ImageView(CloseGuide);
        CloseGuideView.setFitWidth(70);
        CloseGuideView.setPreserveRatio(true);
        CloseGuideView.setEffect(borderGlow);
        CloseGuideView.setX(1600);
        CloseGuideView.setY(155);

        Image Guide = new Image("file:Images/MenuGuideQuestionMark.png");
        GuideView = new ImageView(Guide);
        layout3.getChildren().add(GuideView);
        GuideView.setFitWidth(90);
        GuideView.setPreserveRatio(true);
        GuideView.setEffect(borderGlow);
        GuideView.setX(1790);
        GuideView.setY(10);

        GuideView.setOnMouseEntered(e -> GuideView.setEffect(glowAndShadow));
        GuideView.setOnMouseExited(e -> GuideView.setEffect(borderGlow));

        GuideView.setOnMouseClicked(e->{
            layout3.getChildren().addAll(MenuGuideView,CloseGuideView);
            BackButton1View.setDisable(true);
            GuideView.setDisable(true);
            QuitGameButtonView.setDisable(true);
            if(SFX)
            	MouseClick.play();
        });
        CloseGuideView.setOnMouseClicked(f->{
        	if(SFX)
            	MouseClick.play();
            layout3.getChildren().removeAll(MenuGuideView,CloseGuideView);
            BackButton1View.setDisable(false);
            GuideView.setDisable(false);
            QuitGameButtonView.setDisable(false);
        });

		
		Image NewGameButton = new Image("file:Images/New Game.png");
		NewGameButtonView = new ImageView(NewGameButton);
		layout3.getChildren().add(NewGameButtonView);
		NewGameButtonView.setX(814);
		NewGameButtonView.setY(658);
		NewGameButtonView.setFitWidth(340);
		
		Image QuitGameButton = new Image("file:Images/Quit to desktop.png");
		QuitGameButtonView = new ImageView(QuitGameButton);
		QuitGameButtonView.setX(814);
		QuitGameButtonView.setY(905);
		layout3.getChildren().add(QuitGameButtonView);
		QuitGameButtonView.setFitWidth(340);
		
		layout6 = new AnchorPane();
		OptionsScene = new Scene(layout6, Color.BLACK);
		layout6.styleProperty().set("-fx-background-color: black;");
		
		Image OptionsButton = new Image("file:Images/Options.png");
		OptionsButtonView = new ImageView(OptionsButton);
		layout3.getChildren().add(OptionsButtonView);
		OptionsButtonView.setX(814);
		OptionsButtonView.setY(782);
		OptionsButtonView.setFitWidth(340);
		
		Image OptionsMenu = new Image("file:Images/OptionsMenu.png");
		OptionsMenuView = new ImageView(OptionsMenu);
		//OptionsMenuView.setPreserveRatio(true);
		OptionsMenuView.setFitHeight(primaryStage.getHeight());
		OptionsMenuView.setFitWidth(primaryStage.getWidth());
		
		FadeTransition Layout6Transition = new FadeTransition(Duration.seconds(1), layout6);
		Layout6Transition.setFromValue(0.0);
		Layout6Transition.setToValue(1.0);
		
		Image Tick = new Image("file:Images/Tick.png");
        TickView = new ImageView(Tick);
        TickView.setX(700);
        TickView.setY(740);
        TickView.setFitWidth(100);
        TickView.setPreserveRatio(true);

        TickView2 = new ImageView(Tick);
        TickView2.setX(700);
        TickView2.setY(835);
        TickView2.setFitWidth(100);
        TickView2.setPreserveRatio(true);
		
		Image CheckBox = new Image("file:Images/CheckBox.png");
		CheckBoxView = new ImageView(CheckBox);
		CheckBoxView.setX(709);
		CheckBoxView.setY(745);
		CheckBoxView.setFitWidth(75);
		CheckBoxView.setPreserveRatio(true);
		
		CheckBoxView2 = new ImageView(CheckBox);
		CheckBoxView2.setX(711);
		CheckBoxView2.setY(842);
		CheckBoxView2.setFitWidth(75);
		CheckBoxView2.setPreserveRatio(true);
		
		CheckBoxView.setDisable(true);
        CheckBoxView2.setDisable(true);
        
		CheckBoxView.setOnMouseEntered(e -> {
			if(TickView.isVisible() == false)
				CheckBoxView.setEffect(glowAndShadow);
			else CheckBoxView.setEffect(null);
		});
		CheckBoxView2.setOnMouseEntered(e -> {
			if(TickView2.isVisible() == false)
				CheckBoxView2.setEffect(glowAndShadow);
			else CheckBoxView2.setEffect(null);
		});
		
		CheckBoxView.setOnMouseExited(e -> {
				CheckBoxView.setEffect(null);
		});
		CheckBoxView2.setOnMouseExited(e -> {
				CheckBoxView2.setEffect(null);
		});
		
		TickView.setOnMouseEntered(e -> TickView.setEffect(glowAndShadow));
		TickView.setOnMouseExited(e -> TickView.setEffect(null));
		
		TickView2.setOnMouseEntered(e -> TickView2.setEffect(glowAndShadow));
		TickView2.setOnMouseExited(e -> TickView2.setEffect(null));
		
		QuitGameButtonView2 = new ImageView(QuitGameButton);
		QuitGameButtonView2.setX(765);
		QuitGameButtonView2.setY(550);
		QuitGameButtonView2.setFitWidth(360);
		QuitGameButtonView2.setFitHeight(75);
		
		Image CheckList = new Image("file:Images/CheckList.png");
		CheckListView = new ImageView(CheckList);
		CheckListView = new ImageView(CheckList);
		CheckListView.setX(610);
		CheckListView.setY(640);
			
		Image HowToPlayButton = new Image("file:Images/HowToPlay.png");
		HowToPlayButtonView = new ImageView(HowToPlayButton);
		HowToPlayButtonView.setX(765);
		HowToPlayButtonView.setY(451);
		HowToPlayButtonView.setFitWidth(360);
		HowToPlayButtonView.setFitHeight(100);
		
		FadeTransition PauseTransition = new FadeTransition(Duration.seconds(1), layout6);
    	PauseTransition.setFromValue(0.0);
    	PauseTransition.setToValue(1.0);
    	
    	FadeTransition ContinueTransition = new FadeTransition(Duration.seconds(1), window);
    	ContinueTransition.setFromValue(0.0);
    	ContinueTransition.setToValue(1.0);
		
		Image ContinueButton = new Image("file:Images/Continue.png");
		ContinueButtonView = new ImageView(ContinueButton);
		ContinueButtonView.setX(765);
		ContinueButtonView.setY(263);
		ContinueButtonView.setFitWidth(360);
		ContinueButtonView.setFitHeight(100);
	
		ContinueButtonView.setOnMouseEntered(e -> ContinueButtonView.setEffect(glowAndShadow));
		ContinueButtonView.setOnMouseExited(e -> ContinueButtonView.setEffect(null));
		
		ContinueButtonView.setOnMouseClicked(e ->{
			if(SFX)
            	MouseClick.play();
			
			ContinueButtonView.setVisible(false);
			QuitGameButtonView2.setVisible(false);
			BackButton4View.setVisible(true);
			primaryStage.setScene(scene);
			ContinueTransition.play();
		});
		
		Image RestartAnotherMatch = new Image("file:Images/RestartAnotherMatch.png");
		RestartAnotherMatchView = new ImageView(RestartAnotherMatch);
		RestartAnotherMatchView.setX(753);
		RestartAnotherMatchView.setY(357);
		RestartAnotherMatchView.setFitWidth(385);
		RestartAnotherMatchView.setFitHeight(100);
		
		RestartAnotherMatchView.setOnMouseEntered(e -> RestartAnotherMatchView.setEffect(glowAndShadow));
		RestartAnotherMatchView.setOnMouseExited(e -> RestartAnotherMatchView.setEffect(null));
		
		FadeTransition Layout3Transition = new FadeTransition(Duration.seconds(1), layout3);
		Layout3Transition.setFromValue(0.0);
		Layout3Transition.setToValue(1.0);
		
		RestartAnotherMatchView.setOnMouseClicked(e -> {
			
			ContinueButtonView.setVisible(false);
        	QuitGameButtonView2.setVisible(false);
        	RestartAnotherMatchView.setVisible(false);
        	BackButton4View.setVisible(true);
			Layout3Transition.play();
			if(SFX)
            	MouseClick.play();
			DuelMusic.stop();
			threaten1=false;
	        threaten2=false;
	        deckAlert1 = false;
	        deckAlert2 = false;
	        OT1 = false;
	        OT2 = false;
	        outOfCards1 = false;
	        outOfCards2 = false;
	        overtime = false;
	        SelectYourTargetImageView.setVisible(false);
    		CancelAttackImageView.setVisible(false);
	        GameOverMusic.stop();
	        if(Music)
	        MainMenuMusic.play();
	        primaryStage.setScene(MainMenuScene);
	        window.getChildren().clear();
	        window.getChildren().addAll(pic,PauseView);
		});
		
		QuitGameButtonView2.setOnMouseEntered(e -> QuitGameButtonView2.setEffect(glowAndShadow));
		QuitGameButtonView2.setOnMouseExited(e -> QuitGameButtonView2.setEffect(null));
		
		QuitGameButtonView2.setOnMouseClicked(e ->{
			if(SFX)
            	MouseClick.play();
			System.exit(0);
		});
	    
		Image HowToPlay1 = new Image("file:Images/HowToPlay1.png");
        HowToPlayView1 = new ImageView(HowToPlay1);
        HowToPlayView1.setX(130);
        HowToPlayView1.setY(40);
        HowToPlayView1.setFitHeight(1036);
        HowToPlayView1.setFitWidth(1600);
        HowToPlayView1.setVisible(false);

        Image HowToPlay2 = new Image("file:Images/HowToPlay2.png");
        HowToPlayView2 = new ImageView(HowToPlay2);
        HowToPlayView2.setX(130);
        HowToPlayView2.setY(40);
        HowToPlayView2.setFitHeight(1000);
        HowToPlayView2.setFitWidth(1600);
        HowToPlayView2.setVisible(false);

        Image NextButton = new Image("file:Images/NextButton.png");
        NextButtonView = new ImageView(NextButton);
        NextButtonView.setX(1500);
        NextButtonView.setY(955);
        NextButtonView.setFitHeight(60);
        NextButtonView.setPreserveRatio(true);
        NextButtonView.setEffect(borderGlow);
        NextButtonView.setVisible(false);

        NextButtonView.setOnMouseEntered(e -> NextButtonView.setEffect(glowAndShadow));
        NextButtonView.setOnMouseExited(e -> NextButtonView.setEffect(borderGlow));
		HowToPlayButtonView.setOnMouseEntered(e -> HowToPlayButtonView.setEffect(glowAndShadow));
		HowToPlayButtonView.setOnMouseExited(e -> HowToPlayButtonView.setEffect(null));
		Image PreviousButton = new Image("file:Images/PreviousButton.png");
        PreviousButtonView = new ImageView(PreviousButton);
        PreviousButtonView.setX(1500);
        PreviousButtonView.setY(955);
        PreviousButtonView.setFitHeight(60);
        PreviousButtonView.setPreserveRatio(true);
        PreviousButtonView.setEffect(borderGlow);
        PreviousButtonView.setVisible(false);

        Image CloseHowToPlay = new Image("file:Images/X.png");
        CloseHowToPlayView = new ImageView(CloseHowToPlay);
        CloseHowToPlayView.setPreserveRatio(true);
        CloseHowToPlayView.setFitHeight(120);
        CloseHowToPlayView.setX(1645);
        CloseHowToPlayView.setY(10);
        CloseHowToPlayView.setVisible(false);
        CloseHowToPlayView.setEffect(borderGlow);

        PreviousButtonView.setOnMouseEntered(e -> PreviousButtonView.setEffect(glowAndShadow));
        PreviousButtonView.setOnMouseExited(e -> PreviousButtonView.setEffect(borderGlow));

        HowToPlayButtonView.setOnMouseEntered(e -> HowToPlayButtonView.setEffect(glowAndShadow));
        HowToPlayButtonView.setOnMouseExited(e -> HowToPlayButtonView.setEffect(null));

        CloseHowToPlayView.setOnMouseEntered(e -> CloseHowToPlayView.setEffect(glowAndShadow));
        CloseHowToPlayView.setOnMouseExited(e -> CloseHowToPlayView.setEffect(borderGlow));

        HowToPlayButtonView.setOnMouseClicked(e ->{
            HowToPlayView1.setVisible(true);
            NextButtonView.setVisible(true);
            BackButton4View.setDisable(true);
            CloseHowToPlayView.setVisible(true);
            if(SFX)
            	MouseClick.play();
        });
        CloseHowToPlayView.setOnMouseClicked(e ->{
        	if(SFX)
            	MouseClick.play();
            HowToPlayView1.setVisible(false);
            HowToPlayView2.setVisible(false);
            NextButtonView.setVisible(false);
            PreviousButtonView.setVisible(false);
            CloseHowToPlayView.setVisible(false);
            BackButton4View.setDisable(false);
        });
		BackButton4View = new ImageView(BackButtonImage);
		BackButton4View.setX(22);
		BackButton4View.setY(20);
		
		BackButton4View.setOnMouseEntered(e -> BackButton4View.setEffect(glowAndShadow));
		BackButton4View.setOnMouseExited(e -> BackButton4View.setEffect(null));
		
		BackButton4View.setOnMouseClicked(e ->{
			if(ContinueButtonView.isVisible() == false){
				Layout3Transition.play();
				primaryStage.setScene(MainMenuScene);
			}
				
			if(ContinueButtonView.isVisible()){
				primaryStage.setScene(scene);
				ContinueButtonView.setVisible(false);
				QuitGameButtonView2.setVisible(false);
				RestartAnotherMatchView.setVisible(false);
			}
			if(SFX)
            	MouseClick.play();
				
		});
		
		NextButtonView.setOnMouseClicked(e ->{
			if(SFX)
            	MouseClick.play();
            HowToPlayView2.setVisible(true);
            HowToPlayView1.setVisible(false);
            NextButtonView.setVisible(false);
            PreviousButtonView.setVisible(true);
        });

        PreviousButtonView.setOnMouseClicked(e ->{
        	if(SFX)
            	MouseClick.play();
            HowToPlayView1.setVisible(true);
            HowToPlayView2.setVisible(false);
            NextButtonView.setVisible(true);
            PreviousButtonView.setVisible(false);

        });
        
		ContinueButtonView.setVisible(false);
		QuitGameButtonView2.setVisible(false);
		RestartAnotherMatchView.setVisible(false);
		
		layout6.getChildren().addAll(OptionsMenuView,CheckListView ,CheckBoxView, CheckBoxView2, TickView, TickView2,
                HowToPlayButtonView, ContinueButtonView, QuitGameButtonView2, BackButton4View,
                RestartAnotherMatchView, HowToPlayView1, HowToPlayView2, NextButtonView, PreviousButtonView, CloseHowToPlayView);
		
		TickView.setOnMouseClicked(e ->{
			if(SFX)
            	MouseClick.play();
			if(TickView.isVisible()){
				Music = false;
				TickView.setVisible(false);
				CheckBoxView.setDisable(false);
				if(MainMenuMusic.isPlaying())
					MainMenuMusic.stop();
				if(DuelMusic.isPlaying())
					DuelMusic.stop();
			}
		});
		TickView2.setOnMouseClicked(e ->{
			if(SFX)
            	MouseClick.play();
			if(TickView2.isVisible()){
				SFX = false;
				TickView2.setVisible(false);
				CheckBoxView2.setDisable(false);
			}
		});
		
		CheckBoxView.setOnMouseClicked(e ->{
			if(SFX)
            	MouseClick.play();
			if(TickView.isVisible() == false){
				TickView.setVisible(true);
				CheckBoxView.setDisable(true);
				Music = true;
				
				if(ContinueButtonView.isVisible() == false)
					MainMenuMusic.play();
				else
					DuelMusic.play();
			}
		});
		CheckBoxView2.setOnMouseClicked(e ->{
			if(SFX)
            	MouseClick.play();
			if(TickView2.isVisible() == false){
				TickView2.setVisible(true);
				CheckBoxView2.setDisable(true);
				SFX = true;
			}
		});
		
		NewGameButtonView.setOnMouseEntered(e -> NewGameButtonView.setEffect(glowAndShadow));
		NewGameButtonView.setOnMouseExited(e -> NewGameButtonView.setEffect(null));
		
		BackButton1View.setOnMouseEntered(e -> BackButton1View.setEffect(glowAndShadow));
		BackButton1View.setOnMouseExited(e -> BackButton1View.setEffect(null));
		
		
		OptionsButtonView.setOnMouseEntered(e -> OptionsButtonView.setEffect(glowAndShadow));
		OptionsButtonView.setOnMouseExited(e -> OptionsButtonView.setEffect(null));
		
		OptionsButtonView.setOnMouseClicked(e ->{
			Layout6Transition.play();
			primaryStage.setScene(OptionsScene);
			if(SFX)
            	MouseClick.play();
		});
		
		QuitGameButtonView.setOnMouseEntered(e -> QuitGameButtonView.setEffect(glowAndShadow));
		QuitGameButtonView.setOnMouseExited(e -> QuitGameButtonView.setEffect(null));

	
		StartButtonView.setOnMouseClicked(s -> {	
			primaryStage.setScene(MainMenuScene);
			if(SFX)
            	MouseClick.play();
			Layout3Transition.play();
		
		});
		
		BackButton1View.setOnMouseClicked(e -> {
			primaryStage.setScene(PreMainMenuScene);
			if(SFX)
            	MouseClick.play();
			Layout2Transition.play();
		});
		
		QuitGameButtonView.setOnMouseClicked(e -> {
			if(SFX)
            	MouseClick.play();
			System.exit(0);
		});
		
		Image Player1MenuImage = new Image("file:Images/P1 Menu.png");
		Player1MenuView = new ImageView(Player1MenuImage);
		Player1MenuView.setFitWidth(1900);
		layout4 = new AnchorPane();
		Player1MenuScene = new Scene(layout4,  1980,1080,Color.BLACK);
		
		Image JainaMini = new Image("file:Images/JaineMini.png");
		JainaMiniView = new ImageView(JainaMini);
		JainaMiniView.setX(93);
		JainaMiniView.setY(808);
		
		Image JainaProudmoore = new Image("file:Images/Jaina Proudmoore.jpg");
		JainaProudmooreView = new ImageView(JainaProudmoore);
		JainaProudmooreView.setX(895);
		JainaProudmooreView.setY(154);
		JainaProudmooreView.setFitHeight(623);
		JainaProudmooreView.setFitWidth(978);
		
		Image JainaLabel = new Image("file:Images/JainaLabel.png");
		JainaLabelView = new ImageView(JainaLabel);
		JainaLabelView.setX(1130);
		JainaLabelView.setY(110);
		JainaLabelView.setFitHeight(65);
		JainaLabelView.setFitWidth(500);
		
		Image JainaReview = new Image("file:Images/Jaina Proudmoore Review.jpg");
		JainaReviewView = new ImageView(JainaReview);
		JainaReviewView.setX(170);
		JainaReviewView.setY(110);
		JainaReviewView.setFitHeight(850);
		JainaReviewView.setFitWidth(1600);
		JainaReviewView.setEffect(borderGlowHigh);
		
		Image RexxarMini = new Image("file:Images/RexxarMini.png");
		RexxarMiniView = new ImageView(RexxarMini);
		RexxarMiniView.setX(283);
		RexxarMiniView.setY(808);
		
		Image Rexxar = new Image("file:Images/Rexxar.jpg");
		RexxarView = new ImageView(Rexxar);
		RexxarView.setX(895);
		RexxarView.setY(154);
		RexxarView.setFitHeight(623);
		RexxarView.setFitWidth(978);
		
		Image RexxarLabel = new Image("file:Images/RexxarLabel.png");
		RexxarLabelView = new ImageView(RexxarLabel);
		RexxarLabelView.setX(1240);
		RexxarLabelView.setY(110);
		RexxarLabelView.setFitHeight(65);
		RexxarLabelView.setFitWidth(300);

		Image RexxarReview = new Image("file:Images/Rexxar Review.jpg");
		RexxarReviewView = new ImageView(RexxarReview);
		RexxarReviewView.setX(170);
		RexxarReviewView.setY(110);
		RexxarReviewView.setFitHeight(850);
		RexxarReviewView.setFitWidth(1600);
		
		Image UtherLightbringerMini = new Image("file:Images/UtherLightbringerMini.png");
		UtherLightbringerMiniView = new ImageView(UtherLightbringerMini);
		UtherLightbringerMiniView.setX(485);
		UtherLightbringerMiniView.setY(808);
		
		Image UtherLightbringer = new Image("file:Images/Uther Lightbringer.jpg");
		UtherLightbringerView = new ImageView(UtherLightbringer);
		UtherLightbringerView.setX(895);
		UtherLightbringerView.setY(154);
		UtherLightbringerView.setFitHeight(623);
		UtherLightbringerView.setFitWidth(978);
		
		Image UtherLabel = new Image("file:Images/UtherLabel.png");
		UtherLabelView = new ImageView(UtherLabel);
		UtherLabelView.setX(1130);
		UtherLabelView.setY(110);
		UtherLabelView.setFitHeight(65);
		UtherLabelView.setFitWidth(500);
		
		Image UtherReview = new Image("file:Images/Uther Lightbringer Review.jpg");
		UtherReviewView = new ImageView(UtherReview);
		UtherReviewView.setX(170);
		UtherReviewView.setY(110);
		UtherReviewView.setFitHeight(850);
		UtherReviewView.setFitWidth(1600);
		
		Image GuldanMini = new Image("file:Images/Guld'anMini.png");
		GuldanMiniView = new ImageView(GuldanMini);
		GuldanMiniView.setX(190);
		GuldanMiniView.setY(923);
		
		Image Guldan = new Image("file:Images/Guld'an.jpg");
		GuldanView = new ImageView(Guldan);
		GuldanView.setX(895);
		GuldanView.setY(154);
		GuldanView.setFitHeight(623);
		GuldanView.setFitWidth(978);
		
		Image GuldanLabel = new Image("file:Images/Gul'danLabel.png");
		GuldanLabelView = new ImageView(GuldanLabel);
		GuldanLabelView.setX(1240);
		GuldanLabelView.setY(110);
		GuldanLabelView.setFitHeight(65);
		GuldanLabelView.setFitWidth(300);
		
		Image GuldanReview = new Image("file:Images/Guld'an Review.jpg");
		GuldanReviewView = new ImageView(GuldanReview);
		GuldanReviewView.setX(170);
		GuldanReviewView.setY(110);
		GuldanReviewView.setFitHeight(850);
		GuldanReviewView.setFitWidth(1600);
		
		Image AnduinWrynnMini = new Image("file:Images/AnduinWrynnMini.png");
		AnduinWrynnMiniView = new ImageView(AnduinWrynnMini);
		AnduinWrynnMiniView.setX(384);
		AnduinWrynnMiniView.setY(924);
		
		Image AnduinWrynn = new Image("file:Images/Anduin Wrynn.jpg");
		AnduinWrynnView = new ImageView(AnduinWrynn);
		AnduinWrynnView.setX(895);
		AnduinWrynnView.setY(154);
		AnduinWrynnView.setFitHeight(623);
		AnduinWrynnView.setFitWidth(978);
		
		Image AnduinLabel = new Image("file:Images/AnduinLabel.png");
		AnduinLabelView = new ImageView(AnduinLabel);
		AnduinLabelView.setX(1130);
		AnduinLabelView.setY(110);
		AnduinLabelView.setFitHeight(65);
		AnduinLabelView.setFitWidth(500);
		

		Image AnduinReview = new Image("file:Images/Anduin Wrynn Reveiw.jpg");
		AnduinReviewView = new ImageView(AnduinReview);
		AnduinReviewView.setX(170);
		AnduinReviewView.setY(110);
		AnduinReviewView.setFitHeight(850);
		AnduinReviewView.setFitWidth(1600);
		
		Image select = new Image("file:Images/SelectButton.png");
		selectView = new ImageView(select);
		selectView.setX(1680);
        selectView.setY(995);
        selectView.setFitHeight(65);
        selectView.setFitWidth(190);
		
			
		
		selectView.setOnMouseEntered(e -> selectView.setEffect(glowAndShadow));
		selectView.setOnMouseExited(e -> selectView.setEffect(null));
		
		Image QuestionMark = new Image("file:Images/question mark2.png");
		ImageView QuestionMarkView = new ImageView(QuestionMark);
		QuestionMarkView.setX(1780);
		QuestionMarkView.setY(160);
		QuestionMarkView.setFitHeight(69);
		QuestionMarkView.setFitWidth(98);
		QuestionMarkView.setEffect(borderGlowHigh);
		
		QuestionMarkView2 = new ImageView(QuestionMark);
		
		QuestionMarkView2.setX(1780);
		QuestionMarkView2.setY(160);
		QuestionMarkView2.setFitHeight(69);
		QuestionMarkView2.setFitWidth(98);
		QuestionMarkView2.setEffect(borderGlowHigh);
		
		JainaMiniView.setOnMouseEntered(e -> {
			
			if(ReviewCheck == false){	
				if(JainaMiniView.getEffect()== null)
					JainaMiniView.setEffect(glow);
				if(!layout4.getChildren().contains(JainaProudmooreView))
					layout4.getChildren().addAll(JainaProudmooreView, QuestionMarkView2, JainaLabelView);
				JainaLabelView.setEffect(borderGlow);
			}
		});
		JainaMiniView.setOnMouseExited(e -> {
		
			if(ReviewCheck == false){	
				if(JainaCheck == false){
					JainaMiniView.setEffect(null);
					layout4.getChildren().removeAll(JainaProudmooreView, QuestionMarkView2, JainaLabelView);
				}
			}
			
		});
		
		RexxarMiniView.setOnMouseEntered(e -> {
		
			if(ReviewCheck == false){	
				if(RexxarMiniView.getEffect()== null)
					RexxarMiniView.setEffect(glow);
				if(!layout4.getChildren().contains(RexxarView))
					layout4.getChildren().addAll(RexxarView, QuestionMarkView2, RexxarLabelView);
				RexxarLabelView.setEffect(borderGlow);
			}
				
		});
		RexxarMiniView.setOnMouseExited(e -> {
			
			if(ReviewCheck == false){
				if(RexxarCheck == false){
					RexxarMiniView.setEffect(null);
					layout4.getChildren().removeAll(RexxarView, QuestionMarkView2, RexxarLabelView);
					}
			}
		});
		
		UtherLightbringerMiniView.setOnMouseEntered(e -> {
			
			if(ReviewCheck == false){
				if(UtherLightbringerMiniView.getEffect()== null)
					UtherLightbringerMiniView.setEffect(glow);
				if(!layout4.getChildren().contains(UtherLightbringerView))
					layout4.getChildren().addAll(UtherLightbringerView, QuestionMarkView2, UtherLabelView);
				UtherLabelView.setEffect(borderGlow);
			}
				});
		UtherLightbringerMiniView.setOnMouseExited(e -> {
			
			if(ReviewCheck == false){
				if(UtherCheck == false){
					UtherLightbringerMiniView.setEffect(null);
					layout4.getChildren().removeAll(UtherLightbringerView, QuestionMarkView2, UtherLabelView);
				}
			}
		});
		
		GuldanMiniView.setOnMouseEntered(e -> {
			
			if(ReviewCheck == false){
				if(GuldanMiniView.getEffect()== null)
					GuldanMiniView.setEffect(glow);
				if(!layout4.getChildren().contains(GuldanView))
					layout4.getChildren().addAll(GuldanView, QuestionMarkView2, GuldanLabelView);
				GuldanLabelView.setEffect(borderGlow);
			}
		});
		
		GuldanMiniView.setOnMouseExited(e -> {
			
			if(ReviewCheck == false){
				if(GuldanCheck == false){
					GuldanMiniView.setEffect(null);
					layout4.getChildren().removeAll(GuldanView, QuestionMarkView2, GuldanLabelView);
				}
			}
		});
		
		AnduinWrynnMiniView.setOnMouseEntered(e -> {
		
			if(ReviewCheck == false){
				if(AnduinWrynnMiniView.getEffect()== null)
					AnduinWrynnMiniView.setEffect(glow);
				if(!layout4.getChildren().contains(AnduinWrynnView))
					layout4.getChildren().addAll(AnduinWrynnView, QuestionMarkView2, AnduinLabelView);
				AnduinLabelView.setEffect(borderGlow);
			}
		});
		AnduinWrynnMiniView.setOnMouseExited(e -> {
			
			if(ReviewCheck == false){
				if(AnduinCheck == false){
					AnduinWrynnMiniView.setEffect(null);
					layout4.getChildren().removeAll(AnduinWrynnView, QuestionMarkView2, AnduinLabelView);
				}
			}
		});
		
		// The clicks
		
		JainaMiniView.setOnMouseClicked(e -> {
			
			if(SFX)
            	MouseClick.play();
			
			if(ReviewCheck == false){
				
							
				RexxarCheck = GuldanCheck = UtherCheck = AnduinCheck = false;
				JainaCheck = true;
			
				RexxarMiniView.setEffect(null);
				UtherLightbringerMiniView.setEffect(null);
				GuldanMiniView.setEffect(null);
				AnduinWrynnMiniView.setEffect(null);
				
				JainaLabelView.setEffect(borderGlow);
				RexxarLabelView.setEffect(null);
				UtherLightbringerMiniView.setEffect(null);
				GuldanMiniView.setEffect(null);
				AnduinWrynnMiniView.setEffect(null);
			
				
				if(layout4.getChildren().contains(QuestionMarkView))
					layout4.getChildren().remove(QuestionMarkView);
				if(layout4.getChildren().contains(QuestionMarkView2))
					layout4.getChildren().remove(QuestionMarkView2);
				layout4.getChildren().add(QuestionMarkView);
				
				if(layout4.getChildren().contains(RexxarLabelView))
					layout4.getChildren().remove(RexxarLabelView);
				if(layout4.getChildren().contains(UtherLabelView))
					layout4.getChildren().remove(UtherLabelView);
				if(layout4.getChildren().contains(GuldanLabelView))
					layout4.getChildren().remove(GuldanLabelView);
				if(layout4.getChildren().contains(AnduinLabelView))
					layout4.getChildren().remove(AnduinLabelView);
				
				JainaMiniView.setEffect(glowAndShadow);
				if(layout4.getChildren().contains(RexxarView))
					layout4.getChildren().remove(RexxarView);
				if(layout4.getChildren().contains(UtherLightbringerView))
					layout4.getChildren().remove(UtherLightbringerView);
				if(layout4.getChildren().contains(GuldanView))
					layout4.getChildren().remove(GuldanView);
				if(layout4.getChildren().contains(AnduinWrynnView))
					layout4.getChildren().remove(AnduinWrynnView);
		}
		});
		
		RexxarMiniView.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			
			if(ReviewCheck == false){
			
				JainaCheck = GuldanCheck = UtherCheck = AnduinCheck = false;
				RexxarCheck = true;
				
				JainaMiniView.setEffect(null);
				UtherLightbringerMiniView.setEffect(null);
				GuldanMiniView.setEffect(null);
				AnduinWrynnMiniView.setEffect(null);
				
				JainaLabelView.setEffect(null);
				RexxarLabelView.setEffect(borderGlow);
				UtherLightbringerMiniView.setEffect(null);
				GuldanMiniView.setEffect(null);
				AnduinWrynnMiniView.setEffect(null);
				
				if(layout4.getChildren().contains(QuestionMarkView))
					layout4.getChildren().remove(QuestionMarkView);
				if(layout4.getChildren().contains(QuestionMarkView2))
					layout4.getChildren().remove(QuestionMarkView2);
				layout4.getChildren().add(QuestionMarkView);
				
				RexxarMiniView.setEffect(glowAndShadow);
				if(layout4.getChildren().contains(JainaProudmooreView))
					layout4.getChildren().remove(JainaProudmooreView);
				if(layout4.getChildren().contains(UtherLightbringerView))
					layout4.getChildren().remove(UtherLightbringerView);
				if(layout4.getChildren().contains(GuldanView))
					layout4.getChildren().remove(GuldanView);
				if(layout4.getChildren().contains(AnduinWrynnView))
					layout4.getChildren().remove(AnduinWrynnView);
				
				if(layout4.getChildren().contains(JainaLabelView))
					layout4.getChildren().remove(JainaLabelView);
				if(layout4.getChildren().contains(UtherLabelView))
					layout4.getChildren().remove(UtherLabelView);
				if(layout4.getChildren().contains(GuldanLabelView))
					layout4.getChildren().remove(GuldanLabelView);
				if(layout4.getChildren().contains(AnduinLabelView))
					layout4.getChildren().remove(AnduinLabelView);
			}
		});
		
		UtherLightbringerMiniView.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			
			if(ReviewCheck == false){
				
				JainaCheck = RexxarCheck = GuldanCheck = AnduinCheck = false;
				UtherCheck = true;
				
				JainaMiniView.setEffect(null);
				RexxarMiniView.setEffect(null);
				GuldanMiniView.setEffect(null);
				AnduinWrynnMiniView.setEffect(null);
				
				JainaLabelView.setEffect(null);
				RexxarLabelView.setEffect(null);
				UtherLightbringerMiniView.setEffect(borderGlow);
				GuldanMiniView.setEffect(null);
				AnduinWrynnMiniView.setEffect(null);
				
				if(layout4.getChildren().contains(QuestionMarkView))
					layout4.getChildren().remove(QuestionMarkView);
				if(layout4.getChildren().contains(QuestionMarkView2))
					layout4.getChildren().remove(QuestionMarkView2);
				layout4.getChildren().add(QuestionMarkView);
				
				UtherLightbringerMiniView.setEffect(glowAndShadow);
				if(layout4.getChildren().contains(JainaProudmooreView))
					layout4.getChildren().remove(JainaProudmooreView);
				if(layout4.getChildren().contains(RexxarView))
					layout4.getChildren().remove(RexxarView);
				if(layout4.getChildren().contains(GuldanView))
					layout4.getChildren().remove(GuldanView);
				if(layout4.getChildren().contains(AnduinWrynnView))
					layout4.getChildren().remove(AnduinWrynnView);
				
				if(layout4.getChildren().contains(JainaLabelView))
					layout4.getChildren().remove(JainaLabelView);
				if(layout4.getChildren().contains(RexxarLabelView))
					layout4.getChildren().remove(RexxarLabelView);
				if(layout4.getChildren().contains(GuldanLabelView))
					layout4.getChildren().remove(GuldanLabelView);
				if(layout4.getChildren().contains(AnduinLabelView))
					layout4.getChildren().remove(AnduinLabelView);
			}
		});
	
			
		GuldanMiniView.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			
			if(ReviewCheck == false){
				
				JainaCheck = UtherCheck = RexxarCheck = AnduinCheck = false;
				GuldanCheck = true;
				
				JainaMiniView.setEffect(null);
				UtherLightbringerMiniView.setEffect(null);
				RexxarMiniView.setEffect(null);
				AnduinWrynnMiniView.setEffect(null);
				
				if(layout4.getChildren().contains(QuestionMarkView))
					layout4.getChildren().remove(QuestionMarkView);
				if(layout4.getChildren().contains(QuestionMarkView2))
					layout4.getChildren().remove(QuestionMarkView2);
				layout4.getChildren().add(QuestionMarkView);
				
				JainaLabelView.setEffect(null);
				RexxarLabelView.setEffect(null);
				UtherLightbringerMiniView.setEffect(null);
				GuldanMiniView.setEffect(borderGlow);
				AnduinWrynnMiniView.setEffect(null);
				
				GuldanMiniView.setEffect(glowAndShadow);
				if(layout4.getChildren().contains(JainaProudmooreView))
					layout4.getChildren().remove(JainaProudmooreView);
				if(layout4.getChildren().contains(UtherLightbringerView))
					layout4.getChildren().remove(UtherLightbringerView);
				if(layout4.getChildren().contains(RexxarView))
					layout4.getChildren().remove(RexxarView);
				if(layout4.getChildren().contains(AnduinWrynnView))
					layout4.getChildren().remove(AnduinWrynnView);
				
				if(layout4.getChildren().contains(JainaLabelView))
					layout4.getChildren().remove(JainaLabelView);
				if(layout4.getChildren().contains(RexxarLabelView))
					layout4.getChildren().remove(RexxarLabelView);
				if(layout4.getChildren().contains(UtherLabelView))
					layout4.getChildren().remove(UtherLabelView);
				if(layout4.getChildren().contains(AnduinLabelView))
					layout4.getChildren().remove(AnduinLabelView);	
				
			}
		});
		
		
		AnduinWrynnMiniView.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();;
			
			if(ReviewCheck == false){
				
				JainaCheck = RexxarCheck = GuldanCheck = UtherCheck = false;
				AnduinCheck = true;
				
				JainaMiniView.setEffect(null);
				UtherLightbringerMiniView.setEffect(null);
				GuldanMiniView.setEffect(null);
				RexxarMiniView.setEffect(null);
				
				JainaLabelView.setEffect(null);
				RexxarLabelView.setEffect(null);
				UtherLightbringerMiniView.setEffect(null);
				GuldanMiniView.setEffect(null);
				AnduinWrynnMiniView.setEffect(borderGlow);
				
				if(layout4.getChildren().contains(QuestionMarkView))
					layout4.getChildren().remove(QuestionMarkView);
				if(layout4.getChildren().contains(QuestionMarkView2))
					layout4.getChildren().remove(QuestionMarkView2);
				
				layout4.getChildren().add(QuestionMarkView);	
				AnduinWrynnMiniView.setEffect(glowAndShadow);
				
				if(layout4.getChildren().contains(JainaProudmooreView))
					layout4.getChildren().remove(JainaProudmooreView);
				if(layout4.getChildren().contains(UtherLightbringerView))
					layout4.getChildren().remove(UtherLightbringerView);
				if(layout4.getChildren().contains(GuldanView))
					layout4.getChildren().remove(GuldanView);
				if(layout4.getChildren().contains(RexxarView))
					layout4.getChildren().remove(RexxarView);
				
				if(layout4.getChildren().contains(JainaLabelView))
					layout4.getChildren().remove(JainaLabelView);
				if(layout4.getChildren().contains(RexxarLabelView))
					layout4.getChildren().remove(RexxarLabelView);
				if(layout4.getChildren().contains(UtherLabelView))
					layout4.getChildren().remove(UtherLabelView);
				if(layout4.getChildren().contains(GuldanLabelView))
					layout4.getChildren().remove(GuldanLabelView);
				
			}
		
		});
		
		Image CloseX = new Image("file:Images/CloseX2.png");
		CloseXView = new ImageView(CloseX);
		CloseXView.setX(1680);
		CloseXView.setY(124);
		CloseXView.setFitHeight(69);
		CloseXView.setFitWidth(73);
		CloseXView.setEffect(borderGlow);
		
		CloseXView.setOnMouseClicked(e -> {
			
			if(SFX)
            	MouseClick.play();
			ReviewCheck = false;
			if(JainaCheck)		
				layout4.getChildren().removeAll(JainaReviewView, CloseXView);
			if(RexxarCheck)		
				layout4.getChildren().removeAll(RexxarReviewView, CloseXView);
			if(UtherCheck)		
				layout4.getChildren().removeAll(UtherReviewView, CloseXView);
			if(GuldanCheck)		
				layout4.getChildren().removeAll(GuldanReviewView, CloseXView);
			if(AnduinCheck)		
				layout4.getChildren().removeAll(AnduinReviewView, CloseXView);
		});
		
		
		
		QuestionMarkView.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			if(ReviewCheck == false){
				ReviewCheck = true;

				if(JainaCheck){
					layout4.getChildren().addAll(JainaReviewView, CloseXView);
					JainaReviewView.setEffect(borderGlow);
					
					ReviewTransition = new FadeTransition(Duration.seconds(0.2), JainaReviewView);
					ReviewTransition.setFromValue(0.0);
					ReviewTransition.setToValue(1.0);
					ReviewTransition.play();
				
				}
					
				if(RexxarCheck)	{
					layout4.getChildren().addAll(RexxarReviewView, CloseXView);
					RexxarReviewView.setEffect(borderGlow);
					ReviewTransition = new FadeTransition(Duration.seconds(0.2), RexxarReviewView);
					ReviewTransition.setFromValue(0.0);
					ReviewTransition.setToValue(1.0);
					ReviewTransition.play();
				}

				if(UtherCheck){
					layout4.getChildren().addAll(UtherReviewView, CloseXView);
					UtherReviewView.setEffect(borderGlow);
					ReviewTransition = new FadeTransition(Duration.seconds(0.2), UtherReviewView);
					ReviewTransition.setFromValue(0.0);
					ReviewTransition.setToValue(1.0);
					ReviewTransition.play();
				}
					
				if(GuldanCheck)	{
					layout4.getChildren().addAll(GuldanReviewView, CloseXView);
					GuldanReviewView.setEffect(borderGlow);
					ReviewTransition = new FadeTransition(Duration.seconds(0.2), GuldanReviewView);
					ReviewTransition.setFromValue(0.0);
					ReviewTransition.setToValue(1.0);
					ReviewTransition.play();
				}
					
				if(AnduinCheck)	{
					layout4.getChildren().addAll(AnduinReviewView, CloseXView);
					AnduinReviewView.setEffect(borderGlow);
					ReviewTransition = new FadeTransition(Duration.seconds(0.2), AnduinReviewView);
					ReviewTransition.setFromValue(0.0);
					ReviewTransition.setToValue(1.0);
					ReviewTransition.play();
				}
				
				FadeTransition CloseXReviewTransition = new FadeTransition(Duration.seconds(0.2), CloseXView);
				CloseXReviewTransition.setFromValue(0.0);
				CloseXReviewTransition.setToValue(1.0);
				CloseXReviewTransition.play();
					
			}
		});
		
		Player1Name = new TextField();
		Player1Name.setPromptText("Player1: Click here...");
		Player1Name.setLayoutX(56);
		Player1Name.setLayoutY(498);
		Player1Name.setPrefSize(487, 58);
		Player1Name.setFocusTraversable(false);
		Player1Name.setFont(Font.font("Showcard Gothic", FontWeight.BOLD, 30));
		Player1Name.setStyle("-fx-border-color: black ; -fx-border-width: 7px ; -fx-border-radius: 12; -fx-background-radius: 15");

		
		
		layout4.styleProperty().set("-fx-background-color: black;");
		BackButton2View = new ImageView(BackButtonImage);
		
		layout4.getChildren().addAll(Player1MenuView, BackButton2View, JainaMiniView, RexxarMiniView, UtherLightbringerMiniView,
				GuldanMiniView, AnduinWrynnMiniView, selectView, Player1Name);
		BackButton2View.setX(22);
		BackButton2View.setY(20);
		
		BackButton2View.setOnMouseEntered(e -> BackButton2View.setEffect(glowAndShadow));
		BackButton2View.setOnMouseExited(e -> BackButton2View.setEffect(null));

		FadeTransition Layout4Transition = new FadeTransition(Duration.seconds(0.8), layout4);
		Layout4Transition.setFromValue(0.0);
		Layout4Transition.setToValue(1.0);
		
		BackButton2View.setOnMouseClicked(e -> {
			Layout3Transition.play();
			primaryStage.setScene(MainMenuScene);
			if(SFX)
            	MouseClick.play();	
			
			JainaLabelView.setEffect(null);
			UtherLabelView.setEffect(null);
			GuldanLabelView.setEffect(null);
			RexxarLabelView.setEffect(null);
			AnduinLabelView.setEffect(null);
			
			ReviewCheck = false;
			if(JainaCheck)		
				layout4.getChildren().removeAll(JainaReviewView, CloseXView);
			if(RexxarCheck)		
				layout4.getChildren().removeAll(RexxarReviewView, CloseXView);
			if(UtherCheck)		
				layout4.getChildren().removeAll(UtherReviewView, CloseXView);
			if(GuldanCheck)		
				layout4.getChildren().removeAll(GuldanReviewView, CloseXView);
			if(AnduinCheck)		
				layout4.getChildren().removeAll(AnduinReviewView, CloseXView);
			
			
			
			Player1Name.clear();
			Player1Name.setFocusTraversable(false);
		});
		
		NewGameButtonView.setOnMouseClicked(e -> {
			primaryStage.setScene(Player1MenuScene);
			Layout4Transition.play();
			if(SFX)
            	MouseClick.play();
		}); 
		
		
		
		
		// Setting layout5, Player2MenuScene
		
		layout5 = new AnchorPane();
		Player2MenuScene = new Scene(layout5, 1980,1080 ,Color.BLACK);
		layout5.styleProperty().set("-fx-background-color: black;");
			
		Image Player2MenuImage = new Image("file:Images/P2 Menu.png");
		Player2MenuView = new ImageView(Player2MenuImage);
		
		JainaMiniView2 = new ImageView(JainaMini);
		JainaMiniView2.setX(93);
		JainaMiniView2.setY(808);
		
		JainaProudmooreView2 = new ImageView(JainaProudmoore);
		JainaProudmooreView2.setX(895);
		JainaProudmooreView2.setY(154);
		JainaProudmooreView2.setFitHeight(623);
		JainaProudmooreView2.setFitWidth(978);
		
		JainaLabelView2 = new ImageView(JainaLabel);
		JainaLabelView2.setX(1130);
		JainaLabelView2.setY(110);
		JainaLabelView2.setFitHeight(65);
		JainaLabelView2.setFitWidth(500);
		
		JainaReviewView2 = new ImageView(JainaReview);
		JainaReviewView2.setX(170);
		JainaReviewView2.setY(110);
		JainaReviewView2.setFitHeight(850);
		JainaReviewView2.setFitWidth(1600);
		JainaReviewView2.setEffect(borderGlowHigh);
		
		RexxarMiniView2 = new ImageView(RexxarMini);
		RexxarMiniView2.setX(283);
		RexxarMiniView2.setY(808);
		
		RexxarView2 = new ImageView(Rexxar);
		RexxarView2.setX(895);
		RexxarView2.setY(154);
		RexxarView2.setFitHeight(623);
		RexxarView2.setFitWidth(978);
		
		RexxarLabelView2 = new ImageView(RexxarLabel);
		RexxarLabelView2.setX(1240);
		RexxarLabelView2.setY(110);
		RexxarLabelView2.setFitHeight(65);
		RexxarLabelView2.setFitWidth(300);

		RexxarReviewView2 = new ImageView(RexxarReview);
		RexxarReviewView2.setX(170);
		RexxarReviewView2.setY(110);
		RexxarReviewView2.setFitHeight(850);
		RexxarReviewView2.setFitWidth(1600);
		
		UtherLightbringerMiniView2 = new ImageView(UtherLightbringerMini);
		UtherLightbringerMiniView2.setX(485);
		UtherLightbringerMiniView2.setY(808);
		
		UtherLightbringerView2 = new ImageView(UtherLightbringer);
		UtherLightbringerView2.setX(895);
		UtherLightbringerView2.setY(154);
		UtherLightbringerView2.setFitHeight(623);
		UtherLightbringerView2.setFitWidth(978);
		
		UtherLabelView2 = new ImageView(UtherLabel);
		UtherLabelView2.setX(1130);
		UtherLabelView2.setY(110);
		UtherLabelView2.setFitHeight(65);
		UtherLabelView2.setFitWidth(500);
		
		UtherReviewView2 = new ImageView(UtherReview);
		UtherReviewView2.setX(170);
		UtherReviewView2.setY(110);
		UtherReviewView2.setFitHeight(850);
		UtherReviewView2.setFitWidth(1600);
		
		GuldanMiniView2 = new ImageView(GuldanMini);
		GuldanMiniView2.setX(190);
		GuldanMiniView2.setY(923);
		
		GuldanView2 = new ImageView(Guldan);
		GuldanView2.setX(895);
		GuldanView2.setY(154);
		GuldanView2.setFitHeight(623);
		GuldanView2.setFitWidth(978);
	
		GuldanLabelView2 = new ImageView(GuldanLabel);
		GuldanLabelView2.setX(1240);
		GuldanLabelView2.setY(110);
		GuldanLabelView2.setFitHeight(65);
		GuldanLabelView2.setFitWidth(300);
		
		GuldanReviewView2 = new ImageView(GuldanReview);
		GuldanReviewView2.setX(170);
		GuldanReviewView2.setY(110);
		GuldanReviewView2.setFitHeight(850);
		GuldanReviewView2.setFitWidth(1600);
		
		AnduinWrynnMiniView2 = new ImageView(AnduinWrynnMini);
		AnduinWrynnMiniView2.setX(384);
		AnduinWrynnMiniView2.setY(924);
		
		AnduinWrynnView2 = new ImageView(AnduinWrynn);
		AnduinWrynnView2.setX(895);
		AnduinWrynnView2.setY(154);
		AnduinWrynnView2.setFitHeight(623);
		AnduinWrynnView2.setFitWidth(978);
		
		AnduinLabelView2 = new ImageView(AnduinLabel);
		AnduinLabelView2.setX(1130);
		AnduinLabelView2.setY(110);
		AnduinLabelView2.setFitHeight(65);
		AnduinLabelView2.setFitWidth(500);
		
		AnduinReviewView2 = new ImageView(AnduinReview);
		AnduinReviewView2.setX(170);
		AnduinReviewView2.setY(110);
		AnduinReviewView2.setFitHeight(850);
		AnduinReviewView2.setFitWidth(1600);
		
		selectView2 = new ImageView(select);
		selectView2.setX(1680);
        selectView2.setY(995);
        selectView2.setFitHeight(65);
        selectView2.setFitWidth(190);
		
			
		
		selectView2.setOnMouseEntered(e -> selectView2.setEffect(glowAndShadow));
		selectView2.setOnMouseExited(e -> selectView2.setEffect(null));
		
		QuestionMarkView3 = new ImageView(QuestionMark);	
		QuestionMarkView3.setX(1780);
		QuestionMarkView3.setY(160);
		QuestionMarkView3.setFitHeight(69);
		QuestionMarkView3.setFitWidth(98);
		QuestionMarkView3.setEffect(borderGlowHigh);
		
		QuestionMarkView4 = new ImageView(QuestionMark);	
		QuestionMarkView4.setX(1780);
		QuestionMarkView4.setY(160);
		QuestionMarkView4.setFitHeight(69);
		QuestionMarkView4.setFitWidth(98);
		QuestionMarkView4.setEffect(borderGlowHigh);
		
		JainaMiniView2.setOnMouseEntered(e -> {
			
			if(ReviewCheck2 == false){	
				if(JainaMiniView2.getEffect()== null)
					JainaMiniView2.setEffect(glow);
				if(!layout5.getChildren().contains(JainaProudmooreView2))
					layout5.getChildren().addAll(JainaProudmooreView2, QuestionMarkView4, JainaLabelView2);
				JainaLabelView2.setEffect(borderGlow);
			}
		});
		JainaMiniView2.setOnMouseExited(e -> {
		
			if(ReviewCheck2 == false){	
				if(JainaCheck2 == false){
					JainaMiniView2.setEffect(null);
					layout5.getChildren().removeAll(JainaProudmooreView2, QuestionMarkView4, JainaLabelView2);
				}
			}
			
		});
		
		RexxarMiniView2.setOnMouseEntered(e -> {
		
			if(ReviewCheck2 == false){	
				if(RexxarMiniView2.getEffect()== null)
					RexxarMiniView2.setEffect(glow);
				if(!layout5.getChildren().contains(RexxarView2))
					layout5.getChildren().addAll(RexxarView2, QuestionMarkView4, RexxarLabelView2);
				RexxarLabelView2.setEffect(borderGlow);
			}
				
		});
		RexxarMiniView2.setOnMouseExited(e -> {
			
			if(ReviewCheck2 == false){
				if(RexxarCheck2 == false){
					RexxarMiniView2.setEffect(null);
					layout5.getChildren().removeAll(RexxarView2, QuestionMarkView4, RexxarLabelView2);
					}
			}
		});
		
		UtherLightbringerMiniView2.setOnMouseEntered(e -> {
			
			if(ReviewCheck2 == false){
				if(UtherLightbringerMiniView2.getEffect()== null)
					UtherLightbringerMiniView2.setEffect(glow);
				if(!layout5.getChildren().contains(UtherLightbringerView2))
					layout5.getChildren().addAll(UtherLightbringerView2, QuestionMarkView4, UtherLabelView2);
				UtherLabelView2.setEffect(borderGlow);
			}
				});
		UtherLightbringerMiniView2.setOnMouseExited(e -> {
			
			if(ReviewCheck2 == false){
				if(UtherCheck2 == false){
					UtherLightbringerMiniView2.setEffect(null);
					layout5.getChildren().removeAll(UtherLightbringerView2, QuestionMarkView4, UtherLabelView2);
				}
			}
		});
		
		GuldanMiniView2.setOnMouseEntered(e -> {
			
			if(ReviewCheck2 == false){
				if(GuldanMiniView2.getEffect()== null)
					GuldanMiniView2.setEffect(glow);
				if(!layout5.getChildren().contains(GuldanView2))
					layout5.getChildren().addAll(GuldanView2, QuestionMarkView4, GuldanLabelView2);
				GuldanLabelView2.setEffect(borderGlow);
			}
		});
		
		GuldanMiniView2.setOnMouseExited(e -> {
			
			if(ReviewCheck2 == false){
				if(GuldanCheck2 == false){
					GuldanMiniView2.setEffect(null);
					layout5.getChildren().removeAll(GuldanView2, QuestionMarkView4, GuldanLabelView2);
				}
			}
		});
		
		AnduinWrynnMiniView2.setOnMouseEntered(e -> {
		
			if(ReviewCheck2 == false){
				if(AnduinWrynnMiniView2.getEffect()== null)
					AnduinWrynnMiniView2.setEffect(glow);
				if(!layout5.getChildren().contains(AnduinWrynnView2))
					layout5.getChildren().addAll(AnduinWrynnView2, QuestionMarkView4, AnduinLabelView2);
				AnduinLabelView2.setEffect(borderGlow);
			}
		});
		AnduinWrynnMiniView2.setOnMouseExited(e -> {
			
			if(ReviewCheck2 == false){
				if(AnduinCheck2 == false){
					AnduinWrynnMiniView2.setEffect(null);
					layout5.getChildren().removeAll(AnduinWrynnView2, QuestionMarkView4, AnduinLabelView2);
				}
			}
		});
		
		// The clicks
		
		JainaMiniView2.setOnMouseClicked(e -> {
			
			if(SFX)
            	MouseClick.play();
			
			if(ReviewCheck2 == false){
				
				selectView2.setDisable(false);
			
				RexxarCheck2 = GuldanCheck2 = UtherCheck2 = AnduinCheck2 = false;
				JainaCheck2 = true;
			
				RexxarMiniView2.setEffect(null);
				UtherLightbringerMiniView2.setEffect(null);
				GuldanMiniView2.setEffect(null);
				AnduinWrynnMiniView2.setEffect(null);
				
				JainaLabelView2.setEffect(borderGlow);
				RexxarLabelView2.setEffect(null);
				UtherLightbringerMiniView2.setEffect(null);
				GuldanMiniView2.setEffect(null);
				AnduinWrynnMiniView2.setEffect(null);
			
				
				if(layout5.getChildren().contains(QuestionMarkView3))
					layout5.getChildren().remove(QuestionMarkView3);
				if(layout5.getChildren().contains(QuestionMarkView4))
					layout5.getChildren().remove(QuestionMarkView4);
				layout5.getChildren().add(QuestionMarkView3);
				
				if(layout5.getChildren().contains(RexxarLabelView2))
					layout5.getChildren().remove(RexxarLabelView2);
				if(layout5.getChildren().contains(UtherLabelView2))
					layout5.getChildren().remove(UtherLabelView2);
				if(layout5.getChildren().contains(GuldanLabelView2))
					layout5.getChildren().remove(GuldanLabelView2);
				if(layout5.getChildren().contains(AnduinLabelView2))
					layout5.getChildren().remove(AnduinLabelView2);
				
				JainaMiniView2.setEffect(glowAndShadow);
				if(layout5.getChildren().contains(RexxarView2))
					layout5.getChildren().remove(RexxarView2);
				if(layout5.getChildren().contains(UtherLightbringerView2))
					layout5.getChildren().remove(UtherLightbringerView2);
				if(layout5.getChildren().contains(GuldanView2))
					layout5.getChildren().remove(GuldanView2);
				if(layout5.getChildren().contains(AnduinWrynnView))
					layout5.getChildren().remove(AnduinWrynnView2);
		}
		});
		
		RexxarMiniView2.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			
			if(ReviewCheck2 == false){
				
				selectView2.setDisable(false);
			
				JainaCheck2 = GuldanCheck2 = UtherCheck2 = AnduinCheck2 = false;
				RexxarCheck2 = true;
				
				JainaMiniView2.setEffect(null);
				UtherLightbringerMiniView2.setEffect(null);
				GuldanMiniView2.setEffect(null);
				AnduinWrynnMiniView2.setEffect(null);
				
				JainaLabelView2.setEffect(null);
				RexxarLabelView2.setEffect(borderGlow);
				UtherLightbringerMiniView2.setEffect(null);
				GuldanMiniView2.setEffect(null);
				AnduinWrynnMiniView2.setEffect(null);
				
				if(layout5.getChildren().contains(QuestionMarkView3))
					layout5.getChildren().remove(QuestionMarkView3);
				if(layout5.getChildren().contains(QuestionMarkView4))
					layout5.getChildren().remove(QuestionMarkView4);
				layout5.getChildren().add(QuestionMarkView3);
				
				RexxarMiniView2.setEffect(glowAndShadow);
				if(layout5.getChildren().contains(JainaProudmooreView2))
					layout5.getChildren().remove(JainaProudmooreView2);
				if(layout5.getChildren().contains(UtherLightbringerView2))
					layout5.getChildren().remove(UtherLightbringerView2);
				if(layout5.getChildren().contains(GuldanView2))
					layout5.getChildren().remove(GuldanView2);
				if(layout5.getChildren().contains(AnduinWrynnView2))
					layout5.getChildren().remove(AnduinWrynnView2);
				
				if(layout5.getChildren().contains(JainaLabelView2))
					layout5.getChildren().remove(JainaLabelView2);
				if(layout5.getChildren().contains(UtherLabelView2))
					layout5.getChildren().remove(UtherLabelView2);
				if(layout5.getChildren().contains(GuldanLabelView2))
					layout5.getChildren().remove(GuldanLabelView2);
				if(layout5.getChildren().contains(AnduinLabelView2))
					layout5.getChildren().remove(AnduinLabelView2);
			}
		});
		
		UtherLightbringerMiniView2.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			
			if(ReviewCheck2 == false){
				
				selectView2.setDisable(false);
				
				JainaCheck2 = RexxarCheck2 = GuldanCheck2 = AnduinCheck2 = false;
				UtherCheck2 = true;
				
				JainaMiniView2.setEffect(null);
				RexxarMiniView2.setEffect(null);
				GuldanMiniView2.setEffect(null);
				AnduinWrynnMiniView2.setEffect(null);
				
				JainaLabelView2.setEffect(null);
				RexxarLabelView2.setEffect(null);
				UtherLightbringerMiniView2.setEffect(borderGlow);
				GuldanMiniView2.setEffect(null);
				AnduinWrynnMiniView2.setEffect(null);
				
				if(layout5.getChildren().contains(QuestionMarkView3))
					layout5.getChildren().remove(QuestionMarkView3);
				if(layout5.getChildren().contains(QuestionMarkView4))
					layout5.getChildren().remove(QuestionMarkView4);
				layout5.getChildren().add(QuestionMarkView3);
				
				UtherLightbringerMiniView2.setEffect(glowAndShadow);
				if(layout5.getChildren().contains(JainaProudmooreView2))
					layout5.getChildren().remove(JainaProudmooreView2);
				if(layout5.getChildren().contains(RexxarView2))
					layout5.getChildren().remove(RexxarView2);
				if(layout5.getChildren().contains(GuldanView2))
					layout5.getChildren().remove(GuldanView2);
				if(layout5.getChildren().contains(AnduinWrynnView2))
					layout5.getChildren().remove(AnduinWrynnView2);
				
				if(layout5.getChildren().contains(JainaLabelView2))
					layout5.getChildren().remove(JainaLabelView2);
				if(layout5.getChildren().contains(RexxarLabelView2))
					layout5.getChildren().remove(RexxarLabelView2);
				if(layout5.getChildren().contains(GuldanLabelView2))
					layout5.getChildren().remove(GuldanLabelView2);
				if(layout5.getChildren().contains(AnduinLabelView2))
					layout5.getChildren().remove(AnduinLabelView2);
			}
		});
	
			
		GuldanMiniView2.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			
			selectView2.setDisable(false);
			
			if(ReviewCheck2 == false){
				
				JainaCheck2 = UtherCheck2 = RexxarCheck2 = AnduinCheck2 = false;
				GuldanCheck2 = true;
				
				JainaMiniView2.setEffect(null);
				UtherLightbringerMiniView2.setEffect(null);
				RexxarMiniView2.setEffect(null);
				AnduinWrynnMiniView2.setEffect(null);
				
				if(layout5.getChildren().contains(QuestionMarkView3))
					layout5.getChildren().remove(QuestionMarkView3);
				if(layout5.getChildren().contains(QuestionMarkView4))
					layout5.getChildren().remove(QuestionMarkView4);
				layout5.getChildren().add(QuestionMarkView3);
				
				JainaLabelView2.setEffect(null);
				RexxarLabelView2.setEffect(null);
				UtherLightbringerMiniView2.setEffect(null);
				GuldanMiniView2.setEffect(borderGlow);
				AnduinWrynnMiniView2.setEffect(null);
				
				GuldanMiniView2.setEffect(glowAndShadow);
				if(layout5.getChildren().contains(JainaProudmooreView2))
					layout5.getChildren().remove(JainaProudmooreView2);
				if(layout5.getChildren().contains(UtherLightbringerView2))
					layout5.getChildren().remove(UtherLightbringerView2);
				if(layout5.getChildren().contains(RexxarView2))
					layout5.getChildren().remove(RexxarView2);
				if(layout5.getChildren().contains(AnduinWrynnView2))
					layout5.getChildren().remove(AnduinWrynnView2);
				
				if(layout5.getChildren().contains(JainaLabelView2))
					layout5.getChildren().remove(JainaLabelView2);
				if(layout5.getChildren().contains(RexxarLabelView2))
					layout5.getChildren().remove(RexxarLabelView2);
				if(layout5.getChildren().contains(UtherLabelView2))
					layout5.getChildren().remove(UtherLabelView2);
				if(layout5.getChildren().contains(AnduinLabelView2))
					layout5.getChildren().remove(AnduinLabelView2);	
				
			}
		});
		
		
		AnduinWrynnMiniView2.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			
			selectView2.setDisable(false);
			
			if(ReviewCheck2 == false){
				
				JainaCheck2 = RexxarCheck2 = GuldanCheck2 = UtherCheck2 = false;
				AnduinCheck2 = true;
				
				JainaMiniView2.setEffect(null);
				UtherLightbringerMiniView2.setEffect(null);
				GuldanMiniView2.setEffect(null);
				RexxarMiniView2.setEffect(null);
				
				JainaLabelView2.setEffect(null);
				RexxarLabelView2.setEffect(null);
				UtherLightbringerMiniView2.setEffect(null);
				GuldanMiniView2.setEffect(null);
				AnduinWrynnMiniView2.setEffect(borderGlow);
				
				if(layout5.getChildren().contains(QuestionMarkView3))
					layout5.getChildren().remove(QuestionMarkView3);
				if(layout5.getChildren().contains(QuestionMarkView4))
					layout5.getChildren().remove(QuestionMarkView4);
				layout5.getChildren().add(QuestionMarkView3);	
				
				AnduinWrynnMiniView2.setEffect(glowAndShadow);
				
				if(layout5.getChildren().contains(JainaProudmooreView2))
					layout5.getChildren().remove(JainaProudmooreView2);
				if(layout5.getChildren().contains(UtherLightbringerView2))
					layout5.getChildren().remove(UtherLightbringerView2);
				if(layout5.getChildren().contains(GuldanView2))
					layout5.getChildren().remove(GuldanView2);
				if(layout5.getChildren().contains(RexxarView2))
					layout5.getChildren().remove(RexxarView2);
				
				if(layout5.getChildren().contains(JainaLabelView2))
					layout5.getChildren().remove(JainaLabelView2);
				if(layout5.getChildren().contains(RexxarLabelView2))
					layout5.getChildren().remove(RexxarLabelView2);
				if(layout5.getChildren().contains(UtherLabelView2))
					layout5.getChildren().remove(UtherLabelView2);
				if(layout5.getChildren().contains(GuldanLabelView2))
					layout5.getChildren().remove(GuldanLabelView2);
				
			}
		
		});
		
		CloseXView2 = new ImageView(CloseX);
		CloseXView2.setX(1680);
		CloseXView2.setY(124);
		CloseXView2.setFitHeight(69);
		CloseXView2.setFitWidth(73);
		CloseXView2.setEffect(borderGlow);
		
		CloseXView2.setOnMouseClicked(e -> {
			
			if(SFX)
            	MouseClick.play();
			ReviewCheck2 = false;
			if(JainaCheck2)		
				layout5.getChildren().removeAll(JainaReviewView2, CloseXView2);
			if(RexxarCheck2)		
				layout5.getChildren().removeAll(RexxarReviewView2, CloseXView2);
			if(UtherCheck2)		
				layout5.getChildren().removeAll(UtherReviewView2, CloseXView2);
			if(GuldanCheck2)		
				layout5.getChildren().removeAll(GuldanReviewView2, CloseXView2);
			if(AnduinCheck2)		
				layout5.getChildren().removeAll(AnduinReviewView2, CloseXView2);
		});
		
		
		
		QuestionMarkView3.setOnMouseClicked(e ->{
			
			if(SFX)
            	MouseClick.play();
			if(ReviewCheck2 == false){
				ReviewCheck2 = true;

				if(JainaCheck2){
					layout5.getChildren().addAll(JainaReviewView2, CloseXView2);
					JainaReviewView2.setEffect(borderGlow);
					
					ReviewTransition2 = new FadeTransition(Duration.seconds(0.2), JainaReviewView2);
					ReviewTransition2.setFromValue(0.0);
					ReviewTransition2.setToValue(1.0);
					ReviewTransition2.play();
				
				}
					
				if(RexxarCheck2)	{
					layout5.getChildren().addAll(RexxarReviewView2, CloseXView2);
					RexxarReviewView2.setEffect(borderGlow);
					ReviewTransition2 = new FadeTransition(Duration.seconds(0.2), RexxarReviewView2);
					ReviewTransition2.setFromValue(0.0);
					ReviewTransition2.setToValue(1.0);
					ReviewTransition2.play();
				}

				if(UtherCheck2){
					layout5.getChildren().addAll(UtherReviewView2, CloseXView2);
					UtherReviewView2.setEffect(borderGlow);
					ReviewTransition2 = new FadeTransition(Duration.seconds(0.2), UtherReviewView2);
					ReviewTransition2.setFromValue(0.0);
					ReviewTransition2.setToValue(1.0);
					ReviewTransition2.play();
				}
					
				if(GuldanCheck2)	{
					layout5.getChildren().addAll(GuldanReviewView2, CloseXView2);
					GuldanReviewView2.setEffect(borderGlow);
					ReviewTransition2 = new FadeTransition(Duration.seconds(0.2), GuldanReviewView2);
					ReviewTransition2.setFromValue(0.0);
					ReviewTransition2.setToValue(1.0);
					ReviewTransition2.play();
				}
					
				if(AnduinCheck2)	{
					layout5.getChildren().addAll(AnduinReviewView2, CloseXView2);
					AnduinReviewView2.setEffect(borderGlow);
					ReviewTransition2 = new FadeTransition(Duration.seconds(0.2), AnduinReviewView2);
					ReviewTransition2.setFromValue(0.0);
					ReviewTransition2.setToValue(1.0);
					ReviewTransition2.play();
				}
				
				FadeTransition CloseXReviewTransition2 = new FadeTransition(Duration.seconds(0.2), CloseXView2);
				CloseXReviewTransition2.setFromValue(0.0);
				CloseXReviewTransition2.setToValue(1.0);
				CloseXReviewTransition2.play();
					
			}
		});
		Image Player2Menu = new Image("file:Images/P2 Menu.png");
		Player2MenuView = new ImageView(Player2Menu);
		Player2MenuView.setFitWidth(1900);
		
		Player2Name = new TextField();
		Player2Name.setPromptText("Player2:  Click here...");
		Player2Name.setLayoutX(56);
		Player2Name.setLayoutY(498);
		Player2Name.setPrefSize(487, 58);
		Player2Name.setFocusTraversable(false);
		Player2Name.setFont(Font.font("Showcard Gothic", FontWeight.BOLD, 30));
		Player2Name.setStyle("-fx-border-color: black ; -fx-border-width: 7px ; -fx-border-radius: 12;"
				+ " -fx-background-radius: 15");

		BackButton3View = new ImageView(BackButtonImage);
		
		BackButton3View.setX(22);
		BackButton3View.setY(20);
		
		BackButton3View.setOnMouseEntered(e -> BackButton3View.setEffect(glowAndShadow));
		BackButton3View.setOnMouseExited(e -> BackButton3View.setEffect(null));

		FadeTransition Layout5Transition = new FadeTransition(Duration.seconds(0.8), layout5);
		Layout5Transition.setFromValue(0.0);
		Layout5Transition.setToValue(1.0);
		
		BackButton3View.setOnMouseClicked(e -> {
			Layout3Transition.play();
			primaryStage.setScene(Player1MenuScene);
			if(SFX)
            	MouseClick.play();
			
			JainaMiniView2.setEffect(null);
			UtherLightbringerMiniView2.setEffect(null);
			GuldanMiniView2.setEffect(null);
			RexxarMiniView2.setEffect(null);
			AnduinWrynnView2.setEffect(null);
			
			if(layout5.getChildren().contains(JainaProudmooreView2))
				layout5.getChildren().remove(JainaProudmooreView2);
			if(layout5.getChildren().contains(UtherLightbringerView2))
				layout5.getChildren().remove(UtherLightbringerView2);
			if(layout5.getChildren().contains(GuldanView2))
				layout5.getChildren().remove(GuldanView2);
			if(layout5.getChildren().contains(RexxarView2))
				layout5.getChildren().remove(RexxarView2);
			if(layout5.getChildren().contains(AnduinWrynnView2))
				layout5.getChildren().remove(AnduinWrynnView2);
			
			if(layout5.getChildren().contains(JainaLabelView2))
				layout5.getChildren().remove(JainaLabelView2);
			if(layout5.getChildren().contains(RexxarLabelView2))
				layout5.getChildren().remove(RexxarLabelView2);
			if(layout5.getChildren().contains(UtherLabelView2))
				layout5.getChildren().remove(UtherLabelView2);
			if(layout5.getChildren().contains(AnduinLabelView2))
				layout5.getChildren().remove(AnduinLabelView2);
			if(layout5.getChildren().contains(GuldanLabelView2))
				layout5.getChildren().remove(GuldanLabelView2);
			
			JainaLabelView2.setEffect(null);
			UtherLabelView2.setEffect(null);
			GuldanLabelView2.setEffect(null);
			RexxarLabelView2.setEffect(null);
			AnduinLabelView2.setEffect(null);
			
			if(layout5.getChildren().contains(QuestionMarkView2))
				layout5.getChildren().remove(QuestionMarkView2);
			if(layout5.getChildren().contains(QuestionMarkView4))
				layout5.getChildren().remove(QuestionMarkView4);
			QuestionMarkView3.setEffect(null);
			QuestionMarkView4.setEffect(null);
			
			ReviewCheck2 = false;
			if(JainaCheck2)		
				layout5.getChildren().removeAll(JainaReviewView2, CloseXView2);
			if(RexxarCheck2)		
				layout5.getChildren().removeAll(RexxarReviewView2, CloseXView2);
			if(UtherCheck2)		
				layout5.getChildren().removeAll(UtherReviewView2, CloseXView2);
			if(GuldanCheck2)		
				layout5.getChildren().removeAll(GuldanReviewView2, CloseXView2);
			if(AnduinCheck2)		
				layout5.getChildren().removeAll(AnduinReviewView2, CloseXView2);
			
			Player2Name.clear();
			Player2Name.setFocusTraversable(false);
		});
		
		layout5.getChildren().addAll(Player2MenuView, BackButton3View, JainaMiniView2, RexxarMiniView2, UtherLightbringerMiniView2,
				GuldanMiniView2, AnduinWrynnMiniView2, selectView2, Player2Name);
		Image ManaImage = new Image ("file:Images/Mana.png");
		ManaImageView = new ImageView(ManaImage);
		ManaImageView2 = new ImageView(ManaImage);
		
		selectView.setOnMouseClicked(e -> {
			
			if(SFX)
            	MouseClick.play();
			if(JainaCheck == RexxarCheck == UtherCheck == GuldanCheck == AnduinCheck == true){
				primaryStage.setScene(Player2MenuScene);
				Layout5Transition.play();
				
				if(JainaCheck)		
					layout4.getChildren().removeAll(JainaReviewView, CloseXView);
				if(RexxarCheck)		
					layout4.getChildren().removeAll(RexxarReviewView, CloseXView);
				if(UtherCheck)		
					layout4.getChildren().removeAll(UtherReviewView, CloseXView);
				if(GuldanCheck)		
					layout4.getChildren().removeAll(GuldanReviewView, CloseXView);
				if(AnduinCheck)		
					layout4.getChildren().removeAll(AnduinReviewView, CloseXView);	
			}	
			if(JainaCheck2 == RexxarCheck2 == GuldanCheck2 == UtherCheck2 == AnduinCheck2 == false)
				selectView2.setDisable(true);
		});
	
		BackButton3View.setOnMouseClicked(e -> {
			if(SFX)
            	MouseClick.play();
			primaryStage.setScene(Player1MenuScene);
			Layout4Transition.play();
		});
		
		Image SelectYourTargetImage = new Image ("file:Images/SelectYourTarget.png");
		SelectYourTargetImageView = new ImageView(SelectYourTargetImage);
		SelectYourTargetImageView.setVisible(false);
		SelectYourTargetImageView.setX(420);
		SelectYourTargetImageView.setY(548);
		SelectYourTargetImageView.setFitHeight(25);
		SelectYourTargetImageView.setFitWidth(1100);
		
		Image CancelAttackImage = new Image ("file:Images/CancelAttack.png");
		CancelAttackImageView = new ImageView(CancelAttackImage);
		CancelAttackImageView.setVisible(false);
		CancelAttackImageView.setPreserveRatio(true);
		CancelAttackImageView.setX(1300);
		CancelAttackImageView.setY(525);
		CancelAttackImageView.setEffect(borderGlow);
		CancelAttackImageView.setFitHeight(70);
		CancelAttackImageView.setFitWidth(525);
		
		CancelAttackImageView.setOnMouseEntered(e ->{
			CancelAttackImageView.setEffect(glowAndShadow);
		});
		CancelAttackImageView.setOnMouseExited(e ->{
			CancelAttackImageView.setEffect(borderGlow);
		});
		
		
		window = new AnchorPane();
    	Image img = new Image(getClass().getResourceAsStream("FieldFinal.png"));
    	pic = new ImageView(img);
    	window.getChildren().addAll(pic);
    	
    	playAgain = new Image("file:Images/PlayAgainButton.png");
        playAgainView = new ImageView(playAgain);
        playAgainView.setFitWidth(400);
        playAgainView.setPreserveRatio(true);
        playAgainView.setX(740);
        playAgainView.setY(500);

        playAgainView.setOnMouseEntered(e -> playAgainView.setEffect(glowAndShadow));

        playAgainView.setOnMouseExited(e -> playAgainView.setEffect(null));

        playAgainView.setOnMouseClicked(e ->{
        threaten1=false;
        threaten2=false;
        deckAlert1 = false;
        deckAlert2 = false;
        OT1 = false;
        OT2 = false;
        overtime = false;
        GameOverMusic.stop();
        if(Music)
        MainMenuMusic.play();
        primaryStage.setScene(MainMenuScene);
        window.getChildren().clear();
        window.getChildren().addAll(pic,PauseView, ManaImageView, ManaImageView2);
        });
        
        Quit = new Image("file:Images/Quit to desktop.png");
        QuitView = new ImageView(Quit);
        QuitView.setFitWidth(400);
        QuitView.setPreserveRatio(true);
        QuitView.setX(740);
        QuitView.setY(600);

        QuitView.setOnMouseEntered(e -> QuitView.setEffect(glowAndShadow));

        QuitView.setOnMouseExited(e -> QuitView.setEffect(null));

        QuitView.setOnMouseClicked(e->System.exit(0));
        
        Pause = new Image("file:Images/PauseButton.png");
        PauseView = new ImageView(Pause);
        PauseView.setFitHeight(65);
        PauseView.setFitWidth(200);
        window.getChildren().add(PauseView);
        
        PauseView.setOnMouseEntered(e -> PauseView.setEffect(glowAndShadow));
        PauseView.setOnMouseExited(e -> PauseView.setEffect(null));
        PauseView.setOnMouseClicked( e ->{
        	
        	
        	ContinueButtonView.setVisible(true);
        	QuitGameButtonView2.setVisible(true);
        	RestartAnotherMatchView.setVisible(true);
        	BackButton4View.setVisible(false);
        	if(SFX)
            	MouseClick.play();
        	primaryStage.setScene(OptionsScene);
        	PauseTransition.play();
        });
    	
    	CancelAttackImageView.setOnMouseClicked(e ->{
    		attacking = false;
    		attacker = null;
    		if(SFX)
    		AttackOff.play();
    		
    		Hero1.setOnMouseClicked(x->{
                x.consume();
            });
            Hero2.setOnMouseClicked(y->{
                y.consume();
            });
    				
			Hero1.setEffect(null);
			Hero2.setEffect(null);
			p1hand.setEffect(null);
			p2hand.setEffect(null);
			p1field.setEffect(null);
			p2field.setEffect(null);
			Hero1p.setEffect(null);
			Hero2p.setEffect(null);
			pic.setEffect(null);
			End.setEffect(null);
			Hero1p.setDisable(false);
			Hero2p.setDisable(false);
			p1hand.setDisable(false);
			p2hand.setDisable(false);
			p1Backs.setDisable(false);
			p2Backs.setDisable(false);
			
    		SelectYourTargetImageView.setVisible(false);
    		CancelAttackImageView.setVisible(false);
	
    		verifyField();
			verifyHeroHP();
    		
    	});
    	
    	scene = new Scene(window, 2000, 1080, Color.BLACK);
		
    	selectView2.setOnMouseClicked(e -> {
    		
    		if(SFX)
            	MouseClick.play();
    		selectView2.setDisable(false);
			if(JainaCheck2 == RexxarCheck2 == UtherCheck2 == GuldanCheck2 == AnduinCheck2 == true){
				primaryStage.setScene(scene);
				
				if(JainaCheck2)		
					layout5.getChildren().removeAll(JainaReviewView2, CloseXView2);
				if(RexxarCheck2)		
					layout5.getChildren().removeAll(RexxarReviewView2, CloseXView2);
				if(UtherCheck2)		
					layout5.getChildren().removeAll(UtherReviewView2, CloseXView2);
				if(GuldanCheck2)		
					layout5.getChildren().removeAll(GuldanReviewView2, CloseXView2);
				if(AnduinCheck2)		
					layout5.getChildren().removeAll(AnduinReviewView2, CloseXView2);
				
				try {
					if(JainaCheck){
						player1 = new Mage();
						AttackedClip1 = new AudioClip("file:Sounds/JainaAttacked.wav");
						AttackedClip1.setVolume(0.5);
						
						DeathClip1 = new AudioClip("file:Sounds/JainaDeath.wav");
						DeathClip1.setVolume(0.5);
						
						EntranceClip1 = new AudioClip("file:Sounds/JainaEntrance.wav");
						EntranceClip1.setVolume(0.5);
						
						FieldClip1 = new AudioClip("file:Sounds/JainaField.wav");
						FieldClip1.setVolume(0.5);
						
						HandClip1 = new AudioClip("file:Sounds/JainaHand.wav");
						HandClip1.setVolume(1);
						
						InvalidClip1 = new AudioClip("file:Sounds/JainaInvalidTarget.wav");
						InvalidClip1.setVolume(1);
						
						LowCardsClip1 = new AudioClip("file:Sounds/JainaLowCards.wav");
						LowCardsClip1.setVolume(0.5);
						 
						ManaClip1 = new AudioClip("file:Sounds/JainaMana.wav");
						ManaClip1.setVolume(1);
						
						OutOfCardsClip1 = new AudioClip("file:Sounds/JainaOutOfCards.wav");
						OutOfCardsClip1.setVolume(1);
						
						PowerClip1 = new AudioClip("file:Sounds/JainaPower.wav");
						PowerClip1.setVolume(0.5);
						 
						SleepingClip1 = new AudioClip("file:Sounds/JainaSleeping.wav");
						SleepingClip1.setVolume(0.5);
 
						TauntClip1 = new AudioClip("file:Sounds/JainaTaunt.wav");
						TauntClip1.setVolume(1);
 
						ThreatenClip1 = new AudioClip("file:Sounds/JainaThreaten.wav");
						ThreatenClip1.setVolume(0.5);
					}
					if(RexxarCheck){
						player1 = new Hunter();
						AttackedClip1 = new AudioClip("file:Sounds/RexxarAttacked.wav");
						AttackedClip1.setVolume(0.5);
						
						DeathClip1 = new AudioClip("file:Sounds/RexxarDeath.wav");
						DeathClip1.setVolume(0.5);
						
						EntranceClip1 = new AudioClip("file:Sounds/RexxarEntrance.wav");
						EntranceClip1.setVolume(0.5);
						
						FieldClip1 = new AudioClip("file:Sounds/RexxarField.wav");
						FieldClip1.setVolume(0.5);
						
						HandClip1 = new AudioClip("file:Sounds/RexxarHand.wav");
						HandClip1.setVolume(0.5);
						
						InvalidClip1 = new AudioClip("file:Sounds/RexxarInvalidTarget.wav");
						InvalidClip1.setVolume(1);
						
						LowCardsClip1 = new AudioClip("file:Sounds/RexxarLowCards.wav");
						LowCardsClip1.setVolume(0.5);
						 
						ManaClip1 = new AudioClip("file:Sounds/RexxarMana.wav");
						ManaClip1.setVolume(0.5);
						
						OutOfCardsClip1 = new AudioClip("file:Sounds/RexxarOutOfCards.wav");
						OutOfCardsClip1.setVolume(1);
						
						PowerClip1 = new AudioClip("file:Sounds/RexxarPower.wav");
						PowerClip1.setVolume(1);
						 
						SleepingClip1 = new AudioClip("file:Sounds/RexxarSleeping.wav");
						SleepingClip1.setVolume(1);
 
						TauntClip1 = new AudioClip("file:Sounds/RexxarTaunt.wav");
						TauntClip1.setVolume(0.5);
 
						ThreatenClip1 = new AudioClip("file:Sounds/RexxarThreaten.wav");
						ThreatenClip1.setVolume(1);
					}
					if(UtherCheck){
						player1 = new Paladin();
						AttackedClip1 = new AudioClip("file:Sounds/UtherAttacked.wav");
						AttackedClip1.setVolume(0.5);
						
						DeathClip1 = new AudioClip("file:Sounds/UtherDeath.wav");
						DeathClip1.setVolume(1);
						
						EntranceClip1 = new AudioClip("file:Sounds/UtherEntrance.wav");
						EntranceClip1.setVolume(0.5);
						
						FieldClip1 = new AudioClip("file:Sounds/UtherField.wav");
						FieldClip1.setVolume(1);
						
						HandClip1 = new AudioClip("file:Sounds/UtherHand.wav");
						HandClip1.setVolume(0.5);
						
						InvalidClip1 = new AudioClip("file:Sounds/UtherInvalidTarget.wav");
						InvalidClip1.setVolume(0.5);
						
						LowCardsClip1 = new AudioClip("file:Sounds/UtherLowCards.wav");
						LowCardsClip1.setVolume(1);
						 
						ManaClip1 = new AudioClip("file:Sounds/UtherMana.wav");
						ManaClip1.setVolume(0.5);
						
						OutOfCardsClip1 = new AudioClip("file:Sounds/UtherOutOfCards.wav");
						OutOfCardsClip1.setVolume(1);
						
						PowerClip1 = new AudioClip("file:Sounds/UtherPower.wav");
						PowerClip1.setVolume(0.5);
						 
						SleepingClip1 = new AudioClip("file:Sounds/UtherSleeping.wav");
						SleepingClip1.setVolume(0.5);
 
						TauntClip1 = new AudioClip("file:Sounds/UtherTaunt.wav");
						TauntClip1.setVolume(0.5);
 
						ThreatenClip1 = new AudioClip("file:Sounds/UtherThreaten.wav");
						ThreatenClip1.setVolume(0.5);
					}
					if(GuldanCheck){
						player1 = new Warlock();
						AttackedClip1 = new AudioClip("file:Sounds/GuldanAttacked.wav");
						AttackedClip1.setVolume(0.5);
						
						DeathClip1 = new AudioClip("file:Sounds/GuldanDeath.wav");
						DeathClip1.setVolume(0.5);
						
						EntranceClip1 = new AudioClip("file:Sounds/GuldanEntrance.wav");
						EntranceClip1.setVolume(0.5);
						
						FieldClip1 = new AudioClip("file:Sounds/GuldanField.wav");
						FieldClip1.setVolume(1);
						
						HandClip1 = new AudioClip("file:Sounds/GuldanHand.wav");
						HandClip1.setVolume(0.5);
						
						InvalidClip1 = new AudioClip("file:Sounds/GuldanInvalidTarget.wav");
						InvalidClip1.setVolume(0.5);
						
						LowCardsClip1 = new AudioClip("file:Sounds/GuldanLowCards.wav");
						LowCardsClip1.setVolume(0.5);
						 
						ManaClip1 = new AudioClip("file:Sounds/GuldanMana.wav");
						ManaClip1.setVolume(0.5);
						
						OutOfCardsClip1 = new AudioClip("file:Sounds/GuldanOutOfCards.wav");
						OutOfCardsClip1.setVolume(1);
						
						PowerClip1 = new AudioClip("file:Sounds/GuldanPower.wav");
						PowerClip1.setVolume(1);
						 
						SleepingClip1 = new AudioClip("file:Sounds/GuldanSleeping.wav");
						SleepingClip1.setVolume(1);
 
						TauntClip1 = new AudioClip("file:Sounds/GuldanTaunt.wav");
						TauntClip1.setVolume(1);
 
						ThreatenClip1 = new AudioClip("file:Sounds/GuldanThreaten.wav");
						ThreatenClip1.setVolume(0.5);
					}
					if(AnduinCheck){
						player1 = new Priest();
						AttackedClip1 = new AudioClip("file:Sounds/AnduinAttacked.wav");
						AttackedClip1.setVolume(0.5);
						
						DeathClip1 = new AudioClip("file:Sounds/AnduinDeath.wav");
						DeathClip1.setVolume(1);
						
						EntranceClip1 = new AudioClip("file:Sounds/AnduinEntrance.wav");
						EntranceClip1.setVolume(0.5);
						
						FieldClip1 = new AudioClip("file:Sounds/AnduinField.wav");
						FieldClip1.setVolume(0.5);
						
						HandClip1 = new AudioClip("file:Sounds/AnduinHand.wav");
						HandClip1.setVolume(1);
						
						InvalidClip1 = new AudioClip("file:Sounds/AnduinInvalidTarget.wav");
						InvalidClip1.setVolume(1);
						
						LowCardsClip1 = new AudioClip("file:Sounds/AnduinLowCards.wav");
						LowCardsClip1.setVolume(0.5);
						 
						ManaClip1 = new AudioClip("file:Sounds/AnduinMana.wav");
						ManaClip1.setVolume(1);
						
						OutOfCardsClip1 = new AudioClip("file:Sounds/AnduinOutOfCards.wav");
						OutOfCardsClip1.setVolume(1);
						
						PowerClip1 = new AudioClip("file:Sounds/AnduinPower.wav");
						PowerClip1.setVolume(0.5);
						 
						SleepingClip1 = new AudioClip("file:Sounds/AnduinSleeping.wav");
						SleepingClip1.setVolume(0.5);
 
						TauntClip1 = new AudioClip("file:Sounds/AnduinTaunt.wav");
						TauntClip1.setVolume(0.5);
 
						ThreatenClip1 = new AudioClip("file:Sounds/AnduinThreaten.wav");
						ThreatenClip1.setVolume(0.5);
					}
					if(JainaCheck2){
						player2 = new Mage();
						AttackedClip2 = new AudioClip("file:Sounds/JainaAttacked.wav");
						AttackedClip2.setVolume(0.5);
						
						DeathClip2 = new AudioClip("file:Sounds/JainaDeath.wav");
						DeathClip2.setVolume(0.5);
						
						EntranceClip2 = new AudioClip("file:Sounds/JainaEntrance.wav");
						EntranceClip2.setVolume(0.5);
						
						FieldClip2 = new AudioClip("file:Sounds/JainaField.wav");
						FieldClip2.setVolume(0.5);
						
						HandClip2 = new AudioClip("file:Sounds/JainaHand.wav");
						HandClip2.setVolume(1);
						
						InvalidClip2 = new AudioClip("file:Sounds/JainaInvalidTarget.wav");
						InvalidClip2.setVolume(1);
						
						LowCardsClip2 = new AudioClip("file:Sounds/JainaLowCards.wav");
						LowCardsClip2.setVolume(0.5);
						 
						ManaClip2 = new AudioClip("file:Sounds/JainaMana.wav");
						ManaClip2.setVolume(1);
						
						OutOfCardsClip2 = new AudioClip("file:Sounds/JainaOutOfCards.wav");
						OutOfCardsClip2.setVolume(1);
						
						PowerClip2 = new AudioClip("file:Sounds/JainaPower.wav");
						PowerClip2.setVolume(0.5);
						 
						SleepingClip2 = new AudioClip("file:Sounds/JainaSleeping.wav");
						SleepingClip2.setVolume(0.5);
 
						TauntClip2 = new AudioClip("file:Sounds/JainaTaunt.wav");
						TauntClip2.setVolume(1);
 
						ThreatenClip2 = new AudioClip("file:Sounds/JainaThreaten.wav");
						ThreatenClip2.setVolume(0.5);
					}
					if(RexxarCheck2){
						player2 = new Hunter();
						AttackedClip2 = new AudioClip("file:Sounds/RexxarAttacked.wav");
						AttackedClip2.setVolume(0.5);
						
						DeathClip2 = new AudioClip("file:Sounds/RexxarDeath.wav");
						DeathClip2.setVolume(0.5);
						
						EntranceClip2 = new AudioClip("file:Sounds/RexxarEntrance.wav");
						EntranceClip2.setVolume(0.5);
						
						FieldClip2 = new AudioClip("file:Sounds/RexxarField.wav");
						FieldClip2.setVolume(0.5);
						
						HandClip2 = new AudioClip("file:Sounds/RexxarHand.wav");
						HandClip2.setVolume(0.5);
						
						InvalidClip2 = new AudioClip("file:Sounds/RexxarInvalidTarget.wav");
						InvalidClip2.setVolume(1);
						
						LowCardsClip2 = new AudioClip("file:Sounds/RexxarLowCards.wav");
						LowCardsClip2.setVolume(0.5);
						 
						ManaClip2 = new AudioClip("file:Sounds/RexxarMana.wav");
						ManaClip2.setVolume(0.5);
						
						OutOfCardsClip2 = new AudioClip("file:Sounds/RexxarOutOfCards.wav");
						OutOfCardsClip2.setVolume(1);
						
						PowerClip2 = new AudioClip("file:Sounds/RexxarPower.wav");
						PowerClip2.setVolume(1);
						 
						SleepingClip2 = new AudioClip("file:Sounds/RexxarSleeping.wav");
						SleepingClip2.setVolume(1);
 
						TauntClip2 = new AudioClip("file:Sounds/RexxarTaunt.wav");
						TauntClip2.setVolume(0.5);
 
						ThreatenClip2 = new AudioClip("file:Sounds/RexxarThreaten.wav");
						ThreatenClip2.setVolume(1);
					}
					if(UtherCheck2){
						player2 = new Paladin();
						AttackedClip2 = new AudioClip("file:Sounds/UtherAttacked.wav");
						AttackedClip2.setVolume(0.5);
						
						DeathClip2 = new AudioClip("file:Sounds/UtherDeath.wav");
						DeathClip2.setVolume(1);
						
						EntranceClip2 = new AudioClip("file:Sounds/UtherEntrance.wav");
						EntranceClip2.setVolume(0.5);
						
						FieldClip2 = new AudioClip("file:Sounds/UtherField.wav");
						FieldClip2.setVolume(1);
						
						HandClip2 = new AudioClip("file:Sounds/UtherHand.wav");
						HandClip2.setVolume(0.5);
						
						InvalidClip2 = new AudioClip("file:Sounds/UtherInvalidTarget.wav");
						InvalidClip2.setVolume(0.5);
						
						LowCardsClip2 = new AudioClip("file:Sounds/UtherLowCards.wav");
						LowCardsClip2.setVolume(1);
						 
						ManaClip2 = new AudioClip("file:Sounds/UtherMana.wav");
						ManaClip2.setVolume(0.5);
						
						OutOfCardsClip2 = new AudioClip("file:Sounds/UtherOutOfCards.wav");
						OutOfCardsClip2.setVolume(1);
						
						PowerClip2 = new AudioClip("file:Sounds/UtherPower.wav");
						PowerClip2.setVolume(0.5);
						 
						SleepingClip2 = new AudioClip("file:Sounds/UtherSleeping.wav");
						SleepingClip2.setVolume(0.5);
 
						TauntClip2 = new AudioClip("file:Sounds/UtherTaunt.wav");
						TauntClip2.setVolume(0.5);
 
						ThreatenClip2 = new AudioClip("file:Sounds/UtherThreaten.wav");
						ThreatenClip2.setVolume(0.5);
					}
					if(GuldanCheck2){
						player2 = new Warlock();
						AttackedClip2 = new AudioClip("file:Sounds/GuldanAttacked.wav");
						AttackedClip2.setVolume(0.5);
						
						DeathClip2 = new AudioClip("file:Sounds/GuldanDeath.wav");
						DeathClip2.setVolume(0.5);
						
						EntranceClip2 = new AudioClip("file:Sounds/GuldanEntrance.wav");
						EntranceClip2.setVolume(0.5);
						
						FieldClip2 = new AudioClip("file:Sounds/GuldanField.wav");
						FieldClip2.setVolume(1);
						
						HandClip2 = new AudioClip("file:Sounds/GuldanHand.wav");
						HandClip2.setVolume(0.5);
						
						InvalidClip2 = new AudioClip("file:Sounds/GuldanInvalidTarget.wav");
						InvalidClip2.setVolume(0.5);
						
						LowCardsClip2 = new AudioClip("file:Sounds/GuldanLowCards.wav");
						LowCardsClip2.setVolume(0.5);
						 
						ManaClip2 = new AudioClip("file:Sounds/GuldanMana.wav");
						ManaClip2.setVolume(0.5);
						
						OutOfCardsClip2 = new AudioClip("file:Sounds/GuldanOutOfCards.wav");
						OutOfCardsClip2.setVolume(1);
						
						PowerClip2 = new AudioClip("file:Sounds/GuldanPower.wav");
						PowerClip2.setVolume(1);
						 
						SleepingClip2 = new AudioClip("file:Sounds/GuldanSleeping.wav");
						SleepingClip2.setVolume(1);
 
						TauntClip2 = new AudioClip("file:Sounds/GuldanTaunt.wav");
						TauntClip2.setVolume(1);
 
						ThreatenClip2 = new AudioClip("file:Sounds/GuldanThreaten.wav");
						ThreatenClip2.setVolume(0.5);
					}
					if(AnduinCheck2){
						player2 = new Priest();
						AttackedClip2 = new AudioClip("file:Sounds/AnduinAttacked.wav");
						AttackedClip2.setVolume(0.5);
						
						DeathClip2 = new AudioClip("file:Sounds/AnduinDeath.wav");
						DeathClip2.setVolume(1);
						
						EntranceClip2 = new AudioClip("file:Sounds/AnduinEntrance.wav");
						EntranceClip2.setVolume(0.5);
						
						FieldClip2 = new AudioClip("file:Sounds/AnduinField.wav");
						FieldClip2.setVolume(0.5);
						
						HandClip2 = new AudioClip("file:Sounds/AnduinHand.wav");
						HandClip2.setVolume(1);
						
						InvalidClip2 = new AudioClip("file:Sounds/AnduinInvalidTarget.wav");
						InvalidClip2.setVolume(1);
						
						LowCardsClip2 = new AudioClip("file:Sounds/AnduinLowCards.wav");
						LowCardsClip2.setVolume(0.5);
						 
						ManaClip2 = new AudioClip("file:Sounds/AnduinMana.wav");
						ManaClip2.setVolume(1);
						
						OutOfCardsClip2 = new AudioClip("file:Sounds/AnduinOutOfCards.wav");
						OutOfCardsClip2.setVolume(1);
						
						PowerClip2 = new AudioClip("file:Sounds/AnduinPower.wav");
						PowerClip2.setVolume(0.5);
						 
						SleepingClip2 = new AudioClip("file:Sounds/AnduinSleeping.wav");
						SleepingClip2.setVolume(0.5);
 
						TauntClip2 = new AudioClip("file:Sounds/AnduinTaunt.wav");
						TauntClip2.setVolume(0.5);
 
						ThreatenClip2 = new AudioClip("file:Sounds/AnduinThreaten.wav");
						ThreatenClip2.setVolume(0.5);
					}
					
					 game = new Game(player1, player2);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch blocks
					e1.printStackTrace();
				}
				MainMenuMusic.stop();
				if(Music)
				DuelMusic.play();
				Hero1 = new AnchorPane();				
		        Hero1 = createHero(player1);
		        Mana1 = new Label();
		        Mana1 = heroMana(player1);
		        window.getChildren().add(Mana1);
		        HeroHealth1 = new Label();
		        HeroHealth1 = heroHP(player1);
		        HeroHealth1.setLayoutX(177);
		        HeroHealth1.setLayoutY(982);
		        
		        Hero1.setLayoutX(0);
		        Hero1.setLayoutY(790);
		        Hero1p = new AnchorPane();
		        Hero1p = createHerop(player1);
		        Hero1p.setLayoutX(1700); 
		        Hero1p.setLayoutY(800);
		        
		        game.setListener(this);
				
				p1hand = new HBox();
		        p2hand = new HBox();
		        p1field = new HBox();
		        p2field = new HBox();
		        p1Backs = new HBox();
		        p2Backs = new HBox();		        
		        
		        End = new AnchorPane();
		        Image Endimg = new Image(getClass().getResourceAsStream("Endturn.png"));
		        ImageView Endpic = new ImageView(Endimg);
		        Endpic.setFitHeight(Endimg.getHeight()+210);
			    Endpic.setFitWidth(Endimg.getWidth()+210);
			    Endpic.setPreserveRatio(true);
		        End.getChildren().add(Endpic);
		        window.getChildren().add(End);
		        End.setLayoutX(1590);
		        End.setLayoutY(460);
		        
		        Endpic.setOnMouseEntered(f -> Endpic.setEffect(borderGlow));
		        Endpic.setOnMouseExited(f -> Endpic.setEffect(null));
		        
		        Hero2 = new AnchorPane();
		        Hero2 = createHero(player2);    
		        Mana2 = new Label();     
		        Mana2 = heroMana(player2);
		        window.getChildren().add(Mana2);        
		        HeroHealth2 = new Label();        
		        HeroHealth2 = heroHP(player2);        
		        HeroHealth2.setLayoutX(1876);
		        HeroHealth2.setLayoutY(195);              
		        Hero2.setLayoutX(1700);
		        Hero2.setLayoutY(0);      
		        Hero2p = new AnchorPane();
		        Hero2p = createHerop(player2);       
		        Hero2p.setLayoutX(0);
		        Hero2p.setLayoutY(60);        
				window.getChildren().addAll(p1Backs,p2Backs,p1hand,p2hand,p1field,p2field,
						Hero1,Hero2,Hero1p,Hero2p,HeroHealth1,HeroHealth2, ManaImageView, ManaImageView2);
		        

        		p1hand.setLayoutX(750);
        		p1hand.setLayoutY(850);
		        p1Backs.setLayoutX(750);
		        p1hand.setSpacing(-20);
		        p1Backs.setLayoutX(750);
		        p1Backs.setLayoutY(850);
		        p2hand.setLayoutY(15);
		        p2Backs.setLayoutY(15);
		        p1Backs.setSpacing(0);
		        
		        p2hand.setLayoutX(750);
		        p2Backs.setLayoutX(750);
		        p2hand.setSpacing(-20);
		        p2Backs.setSpacing(0);

		        p1field.setLayoutX(340);
		        p1field.setLayoutY(575);
		        p2field.setLayoutX(340);
		        p2field.setLayoutY(290);
		        p1field.setSpacing(0);
		        p2field.setSpacing(0);
		
		        P1name = new Label();
                P2name = new Label();
                P1name.setFont(Font.font("Showcard Gothic", FontWeight.BOLD, 32));
                P1name.setTextFill(Color.WHITE);
                P2name.setFont(Font.font("Showcard Gothic", FontWeight.BOLD, 32));
                P2name.setTextFill(Color.WHITE);
                if(Player1Name.getText().equals(""))
                    P1name.setText("Player 1");
                else 
                    P1name.setText(Player1Name.getText());

                if(Player2Name.getText().equals(""))
                    P2name.setText("Player 2");
                else 
                    P2name.setText(Player2Name.getText());
                window.getChildren().addAll(P1name,P2name);
                int x = P1name.getText().length();
                int y = P2name.getText().length();
                P1name.setLayoutX(105 - (x*7));
                P1name.setLayoutY(750);
                P2name.setLayoutX(1805 - (y*7));
                P2name.setLayoutY(285);
  
		        if(game.getCurrentHero().equals(player1)){
		        	int i=0;
		        	int j=0;
		        	if(SFX)
		        	EntranceClip1.play();
		        	while(i<player2.getHand().size()){
		        		p2Backs.getChildren().add(backcreator());
		        		i++;
		        	}
		        	while(j<player1.getHand().size()){
		        		p1Backs.getChildren().add(backcreator());
		        		card1 = new AnchorPane();
		                card1 = cardcreator(player1.getHand().get(j));
		                p1hand.getChildren().add(card1);
		                setHandClickable(player1.getHand().get(j), card1, player1, p1field,p1hand);
		        		j++;
		        		} 
		        		p1Backs.setVisible(false);
		        		p1hand.setVisible(true); 
		        		p2Backs.setVisible(true);
		        		p2hand.setVisible(false);
		        		
	    		        p2hand.setLayoutX(600);
	    		        p2Backs.setLayoutX(680);
	    		        //p2hand.setSpacing(-20);
	    		        p2Backs.setSpacing(0);
		        		}
		        	else if(game.getCurrentHero().equals(player2)){
		        	if(SFX)
		        	EntranceClip2.play();
		        	int i=0;
		        	int j=0;
		        	while(i<player1.getHand().size()){
		        		p1Backs.getChildren().add(backcreator());
		        		i++;
		        		}
		        	while(j<player2.getHand().size()){
		        		p2Backs.getChildren().add(backcreator());
		        		card2 = new AnchorPane();
		                card2 = cardcreator(player2.getHand().get(j));
		                p2hand.getChildren().add(card2);
		                setHandClickable(player2.getHand().get(j), card2, player2, p2field,p2hand);
		        		j++;
		        		}
		        		p2Backs.setVisible(false);
		        		p2hand.setVisible(true);
		        		p1Backs.setVisible(true);
		        		p1hand.setVisible(false);
		        		
		        		p1hand.setLayoutX(620);
	    		        p1Backs.setLayoutX(680);
	    		        p1hand.setSpacing(-20);
	    		        p1Backs.setSpacing(0);
		        		}
		        		
		        		verifyMana(); 		
	            		verifyDecks();
	            		
		        		End.setOnMouseClicked(s->{
		        			
		        			verifyHeroHP();
		        			
		        			Hero1.setOnMouseClicked(a->{
                                a.consume();
                            });
                            Hero2.setOnMouseClicked(b->{
                                b.consume();
                            });


		        			Hero1.setEffect(null);
							Hero2.setEffect(null);
							p1hand.setEffect(null);
							p2hand.setEffect(null);
							p1field.setEffect(null);
							p2field.setEffect(null);
							Hero1p.setEffect(null);
							Hero2p.setEffect(null);
							pic.setEffect(null);
							End.setEffect(null);
							End.setEffect(null);
							Hero1p.setDisable(false);
							Hero2p.setDisable(false);
							p1hand.setDisable(false);
							p2hand.setDisable(false);
							p1Backs.setDisable(false);
							p2Backs.setDisable(false);
		    					
		    				SelectYourTargetImageView.setVisible(false);
		    				CancelAttackImageView.setVisible(false);
		        			attacking = false;
		        			attacker = null;
		        			
		        		if(game.getCurrentHero().equals(player2)){
		        			try {
								game.endTurn();
								if(SFX)
								Draw.play();
			        			verifyMana();
			        			verifyDecks();
			        			
		        			} catch (Exception e1){
		        				if(e1 instanceof FullHandException && SFX){
		        					HandClip1.play();
		        					Draw.stop();
		        				}
								AlertBox.display("Error",e1.getMessage());
							}
		        			
		        			if(p1hand.getChildren().size() == 0 && player1.getField().contains("Chromaggus") && player1.getHand().size()>0 ){
			        			p1hand.setLayoutX(780);
			    		        p1Backs.setLayoutX(780);
		        			}
		        			if(p1hand.getChildren().size() == 1){
		        				
		        				p1hand.setLayoutX(590);
			    		        p1Backs.setLayoutX(590);
			    		        p1hand.setSpacing(-20);
			    		       // p1Backs.setSpacing(0);
		        				
		        				for(int i = 0; i < player1.getField().size() && player1.getHand().size()>0 ;i++){
		        					if(player1.getField().get(i).getName().equals("Chromaggus") ){
		        						
		        						p1hand.setLayoutX(660);
					    		        p1Backs.setLayoutX(660);
					    		        break;
		        						
		        					}        					
		        			}
		        		}
		            		if(p1hand.getChildren().size() == 2){
		            			
			        			p1hand.setLayoutX(750);
			    		        p1Backs.setLayoutX(750);
			    		        p1hand.setSpacing(-20);
			    		      //  p1Backs.setSpacing(0);
			    		        
		            			
			    		        for(int i = 0; i < player1.getField().size() && player1.getHand().size()>0 ;i++){
		        					if(player1.getField().get(i).getName().equals("Chromaggus") ){
		        						
		        						p1hand.setLayoutX(590);
					    		        p1Backs.setLayoutX(590);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			
		        			if(p1hand.getChildren().size() == 3){
		        				
			        			p1hand.setLayoutX(640);
			    		        p1Backs.setLayoutX(640);
			    		        p1hand.setSpacing(-20);
			    		        p1Backs.setSpacing(0);
			    		        p2Backs.setLayoutX(580);
			    		        
			    		        for(int i = 0; i < player1.getField().size() && player1.getHand().size()>0 ;i++){
		        					if(player1.getField().get(i).getName().equals("Chromaggus") ){
		        						
		        						p1hand.setLayoutX(505);
					    		        p1Backs.setLayoutX(505);
					    		        break;
		        						
		        					}        					
		        			}
			    		        
		        				}
		        			
		        			if(p1hand.getChildren().size() == 4){

			        			p1hand.setLayoutX(560);
			    		        p1Backs.setLayoutX(560);
			    		        p1hand.setSpacing(-20);
			    		        p1Backs.setSpacing(0);
			    		        
			    		        
			    		        
			    		        for(int i = 0; i < player1.getField().size() && player1.getHand().size()>0 ;i++){
		        					if(player1.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p1hand.setLayoutX(450);
					    		        p1Backs.setLayoutX(450);
					    		        break;
		        						
		        					}        					
		        			}
		        				}
		        			
		        			if(p1hand.getChildren().size() == 5){
		        				
			        			p1hand.setLayoutX(470);
			    		        p1Backs.setLayoutX(470);
			    		        p1hand.setSpacing(-20);
			    		       // p1Backs.setSpacing(0);
		        				
			    		        for(int i = 0; i < player1.getField().size() && player1.getHand().size()>0 ;i++){
		        					if(player1.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p1hand.setLayoutX(370);
					    		        p1Backs.setLayoutX(370);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			if(p1hand.getChildren().size() == 6){
		        				
			        			p1hand.setLayoutX(410);
			    		        p1Backs.setLayoutX(410);
			    		        p1hand.setSpacing(-20);
			    		       // p1Backs.setSpacing(0);
		        				
			    		        for(int i = 0; i < player1.getField().size() && player1.getHand().size()>0 ;i++){
		        					if(player1.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p1hand.setLayoutX(335);
					    		        p1Backs.setLayoutX(335);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			if(p1hand.getChildren().size() == 7){
		        				
			        			p1hand.setLayoutX(340);
			    		        p1Backs.setLayoutX(340);
			    		        p1hand.setSpacing(-20);
			    		       // p1Backs.setSpacing(0);
		        				
			    		        for(int i = 0; i < player1.getField().size() && player1.getHand().size()>0 ;i++){
		        					if(player1.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p1hand.setLayoutX(270);
				        				p1Backs.setLayoutX(270);
				        				p1Backs.setSpacing(0);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			if(p1hand.getChildren().size() == 8){
		        				
			        			p1hand.setLayoutX(260);
			    		        p1Backs.setLayoutX(260);
			    		        p1Backs.setSpacing(5.5);
			    		       // p1hand.setSpacing(-20);
		        				
			    		        for(int i = 0; i < player1.getField().size() && player1.getHand().size()>0 ;i++){
		        					if(player1.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p1hand.setLayoutX(285);
				        				p1Backs.setLayoutX(285);
				        				p1hand.setSpacing(-39);
				        				p1Backs.setSpacing(-20);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			
		        			if(p1hand.getChildren().size() == 9){
		        				p1hand.setLayoutX(260);
		        				p1Backs.setLayoutX(260);
		        				p1hand.setSpacing(-39);
		        				p1Backs.setSpacing(-10);
		        			}
		        			if(p1hand.getChildren().size() == 10){
		        				p1hand.setLayoutX(260);
		        				p1Backs.setLayoutX(260);
		        				p1hand.setSpacing(-39);
		        		        p1Backs.setSpacing(-10);
		        			}
		        			
		        			
		        			verifyField();
		        			verifyMana();
		        			verifyHeroHP();
		        			verifyHand();
		        			verifyDecks();
		          			p2Backs.setVisible(true);
		          			p2hand.setVisible(false);		
		          			p1Backs.setVisible(false);
		        			p1hand.setVisible(true);
		        			
		        		}
		        		else if(game.getCurrentHero().equals(player1)){
		        			try {
								game.endTurn();
								if(SFX)
								Draw.play();
			        			verifyMana();
			        			verifyDecks();
			        			
		        			} catch (Exception e1){
		        				 	if(e1 instanceof FullHandException&& SFX ){
		        				 		HandClip2.play();
		        				 		Draw.stop();
		        				 		}
									AlertBox.display("Error",e1.getMessage());
							}
		        			
		        				//for player2
		        			
		        			if(p2hand.getChildren().size() == 0 && player2.getField().contains("Chromaggus") && player2.getHand().size()>0 ){
			        			p2hand.setLayoutX(780);
			    		        p2Backs.setLayoutX(780);
		        			}
		        			if(p2hand.getChildren().size() == 1){
		        				
		        				p2hand.setLayoutX(590);
			    		        p2Backs.setLayoutX(590);
			    		        p2hand.setSpacing(-20);
			    		       // p2Backs.setSpacing(0);
		        				
		        				for(int i = 0; i < player2.getField().size() && player2.getHand().size()>0 ;i++){
		        					if(player2.getField().get(i).getName().equals("Chromaggus") ){
		        						
		        						p2hand.setLayoutX(660);
					    		        p2Backs.setLayoutX(660);
					    		        break;
		        						
		        					}        					
		        			}
		        		}
		            		if(p2hand.getChildren().size() == 2){
		            			
			        			p2hand.setLayoutX(750);
			    		        p2Backs.setLayoutX(760);
			    		        p2hand.setSpacing(-20);
			    		      //  p2Backs.setSpacing(0);
		            			
			    		        for(int i = 0; i < player2.getField().size() && player2.getHand().size()>0 ;i++){
		        					if(player2.getField().get(i).getName().equals("Chromaggus") ){
		        						
		        						p2hand.setLayoutX(590);
					    		        p2Backs.setLayoutX(590);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			
		        			if(p2hand.getChildren().size() == 3){
		        				
			        			p2hand.setLayoutX(640);
			    		        p2Backs.setLayoutX(660);
			    		        p2hand.setSpacing(-20);
			    		       // p2Backs.setSpacing(0);
			    		        p1Backs.setLayoutX(600);
			    		        
			    		        for(int i = 0; i < player2.getField().size() && player2.getHand().size()>0 ;i++){
		        					if(player2.getField().get(i).getName().equals("Chromaggus") ){
		        						
		        						p2hand.setLayoutX(505);
					    		        p2Backs.setLayoutX(505);
					    		        break;
		        						
		        					}        					
		        			}
			    		        
		        				}
		        			
		        			if(p2hand.getChildren().size() == 4){


			        			p2hand.setLayoutX(530);
			    		        p2Backs.setLayoutX(530);
			    		        p2hand.setSpacing(-20);
			    		      //  p2Backs.setSpacing(0);
			    		        
			    		        for(int i = 0; i < player2.getField().size() && player2.getHand().size()>0 ;i++){
		        					if(player2.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p2hand.setLayoutX(450);
					    		        p2Backs.setLayoutX(450);
					    		        break;
		        						
		        					}        					
		        			}
		        				}
		        			
		        			if(p2hand.getChildren().size() == 5){
		        				
			        			p2hand.setLayoutX(500);
			    		        p2Backs.setLayoutX(500);
			    		        p2hand.setSpacing(-20);
			    		      //  p2Backs.setSpacing(0);
		        				
			    		        for(int i = 0; i < player2.getField().size() && player2.getHand().size()>0 ;i++){
		        					if(player2.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p2hand.setLayoutX(370);
					    		        p2Backs.setLayoutX(370);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			if(p2hand.getChildren().size() == 6){
		        				
			        			p2hand.setLayoutX(410);
			    		        p2Backs.setLayoutX(410);
			    		        p2hand.setSpacing(-20);
			    		       // p2Backs.setSpacing(3);
		        				
			    		        for(int i = 0; i < player2.getField().size() && player2.getHand().size()>0 ;i++){
		        					if(player2.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p2hand.setLayoutX(335);
					    		        p2Backs.setLayoutX(335);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			if(p2hand.getChildren().size() == 7){
		        				
			        			p2hand.setLayoutX(340);
			    		        p2Backs.setLayoutX(340);
			    		        p2hand.setSpacing(-20);
			    		       // p2Backs.setSpacing(0);
		        				
			    		        for(int i = 0; i < player2.getField().size() && player2.getHand().size()>0 ;i++){
		        					if(player2.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p2hand.setLayoutX(267);
				        				p2Backs.setLayoutX(267);
				        				p2Backs.setSpacing(0);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			if(p2hand.getChildren().size() == 8){
		        				
			        			p2hand.setLayoutX(260);
			    		        p2Backs.setLayoutX(260);
			    		        p2Backs.setSpacing(5.5);
			    		       // p2hand.setSpacing(-20);
		        				
			    		        for(int i = 0; i < player2.getField().size() && player2.getHand().size()>0 ;i++){
		        					if(player2.getField().get(i).getName().equals("Chromaggus")){
		        						
		        						p2hand.setLayoutX(285);
				        				p2Backs.setLayoutX(285);
				        				p2hand.setSpacing(-39);
				        				p2Backs.setSpacing(-10);
					    		        break;
		        						
		        					}        					
		        			}
		        			}
		        			
		        			if(p2hand.getChildren().size() == 9){
		        				p2hand.setLayoutX(260);
		        				p2Backs.setLayoutX(260);
		        				p2hand.setSpacing(-39);
		        				p2Backs.setSpacing(-10);
		        			}
		        			if(p2hand.getChildren().size() == 10){
		        				p2hand.setLayoutX(260);
		        				p1Backs.setLayoutX(260);
		        				p2hand.setSpacing(-39);
		        		        p2Backs.setSpacing(-10);
		        			}
		        			
		        			
		        			verifyMana();
		        			verifyField();
		        			verifyHeroHP();
		        			verifyHand(); 
		        			verifyDecks();
		        			p2Backs.setVisible(false);
		        			p2hand.setVisible(true);
		        			p1Backs.setVisible(true);   
		        			p1hand.setVisible(false);
		        			}
		        		});
		        		
		        	Hero1p.setOnMouseClicked(b->{
		        		power = true;
	    				if(player1 instanceof Hunter){
	    					if(power == true)
	    					try {
								player1.useHeroPower();
								if(SFX)
								AttackDone.play();
								
							} catch (Exception e1) {
								AttackDone.stop();
								if(e1 instanceof NotEnoughManaException && SFX)
									ManaClip1.play();
								if(e1 instanceof HeroPowerAlreadyUsedException && SFX )
									PowerClip1.play();
				
								 AlertBox.display("ERROR",e1.getMessage());
								 if(SFX)
								 AttackOff.play();
							}
	    					verifyHeroHP();
							verifyMana();
							power=false;
	    					}
	    		  else  if(player1 instanceof Warlock){
	    			  		if(power == true)
	    			  		try {
	    			  			player1.useHeroPower();
	    			  			if(SFX)
	    			  			Draw.play();
	    			  			card1 = new AnchorPane();
	    		                card1 = cardcreator(player1.getHand().get(player1.getHand().size()-1));
	    		                p1hand.getChildren().add(card1);
	    						p1Backs.getChildren().add(backcreator());
	    		                setHandClickable(player1.getHand().get(player1.getHand().size()-1), card1, player1, p1field,p1hand);
	    		                
	    		                if(p1hand.getChildren().size()-1 == 0 && player1.getField().contains("Chromaggus") && player1.getHand().size()>0 ){
				        			p1hand.setLayoutX(780);
				    		        p1Backs.setLayoutX(780);
			        			}
			        			if(p1hand.getChildren().size()-1 == 1){
			        				
			        				p1hand.setLayoutX(590);
				    		        p1Backs.setLayoutX(590);
				    		        p1hand.setSpacing(-20);
				    		       // p1Backs.setSpacing(0);
			        				
			        				for(int i = 0; i < player1.getField().size()-1 && player1.getHand().size()>0 ;i++){
			        					if(player1.getField().get(i).getName().equals("Chromaggus") ){
			        						
			        						p1hand.setLayoutX(660);
						    		        p1Backs.setLayoutX(660);
						    		        break;
			        						
			        					}        					
			        			}
			        		}
			            		if(p1hand.getChildren().size()-1 == 2){
			            			
				        			p1hand.setLayoutX(750);
				    		        p1Backs.setLayoutX(750);
				    		        p1hand.setSpacing(-20);
				    		      //  p1Backs.setSpacing(0);
				    		        
			            			
				    		        for(int i = 0; i < player1.getField().size() -1&& player1.getHand().size()>0 ;i++){
			        					if(player1.getField().get(i).getName().equals("Chromaggus") ){
			        						
			        						p1hand.setLayoutX(590);
						    		        p1Backs.setLayoutX(590);
						    		        break;
			        						
			        					}        					
			        			}
			        			}
			        			
			        			if(p1hand.getChildren().size()-1 == 3){
			        				
				        			p1hand.setLayoutX(640);
				    		        p1Backs.setLayoutX(640);
				    		        p1hand.setSpacing(-20);
				    		        p1Backs.setSpacing(0);
				    		        p2Backs.setLayoutX(580);
				    		        
				    		        for(int i = 0; i < player1.getField().size()-1 && player1.getHand().size()>0 ;i++){
			        					if(player1.getField().get(i).getName().equals("Chromaggus") ){
			        						
			        						p1hand.setLayoutX(505);
						    		        p1Backs.setLayoutX(505);
						    		        break;
			        						
			        					}        					
			        			}
				    		        
			        				}
			        			
			        			if(p1hand.getChildren().size()-1 == 4){

				        			p1hand.setLayoutX(560);
				    		        p1Backs.setLayoutX(560);
				    		        p1hand.setSpacing(-20);
				    		        p1Backs.setSpacing(0);
				    		        
				    		        
				    		        
				    		        for(int i = 0; i < player1.getField().size() -1&& player1.getHand().size()>0 ;i++){
			        					if(player1.getField().get(i).getName().equals("Chromaggus")){
			        						
			        						p1hand.setLayoutX(450);
						    		        p1Backs.setLayoutX(450);
						    		        break;
			        						
			        					}        					
			        			}
			        				}
			        			
			        			if(p1hand.getChildren().size()-1 == 5){
			        				
				        			p1hand.setLayoutX(470);
				    		        p1Backs.setLayoutX(470);
				    		        p1hand.setSpacing(-20);
				    		       // p1Backs.setSpacing(0);
			        				
				    		        for(int i = 0; i < player1.getField().size() -1&& player1.getHand().size()>0 ;i++){
			        					if(player1.getField().get(i).getName().equals("Chromaggus")){
			        						
			        						p1hand.setLayoutX(370);
						    		        p1Backs.setLayoutX(370);
						    		        break;
			        						
			        					}        					
			        			}
			        			}
			        			if(p1hand.getChildren().size()-1 == 6){
			        				
				        			p1hand.setLayoutX(410);
				    		        p1Backs.setLayoutX(410);
				    		        p1hand.setSpacing(-20);
				    		       // p1Backs.setSpacing(0);
			        				
				    		        for(int i = 0; i < player1.getField().size()-1 && player1.getHand().size()>0 ;i++){
			        					if(player1.getField().get(i).getName().equals("Chromaggus")){
			        						
			        						p1hand.setLayoutX(335);
						    		        p1Backs.setLayoutX(335);
						    		        break;
			        						
			        					}        					
			        			}
			        			}
			        			if(p1hand.getChildren().size()-1 == 7){
			        				
				        			p1hand.setLayoutX(320);
				    		        p1Backs.setLayoutX(320);
				    		        p1hand.setSpacing(-20);
				    		        p1Backs.setSpacing(0);
			        				
				    		        for(int i = 0; i < player1.getField().size()-1 && player1.getHand().size()>0 ;i++){
			        					if(player1.getField().get(i).getName().equals("Chromaggus")){
			        						
			        						p1hand.setLayoutX(270);
					        				p1Backs.setLayoutX(270);
					        				p1Backs.setSpacing(0);
						    		        break;
			        						
			        					}        					
			        			}
			        			}
			        			if(p1hand.getChildren().size()-1 == 8){
			        				
				        			p1hand.setLayoutX(260);
				    		        p1Backs.setLayoutX(260);
				    		        p1Backs.setSpacing(5.5);
				    		       // p1hand.setSpacing(-20);
			        				
				    		        for(int i = 0; i < player1.getField().size()-1 && player1.getHand().size()>0 ;i++){
			        					if(player1.getField().get(i).getName().equals("Chromaggus")){
			        						
			        						p1hand.setLayoutX(285);
					        				p1Backs.setLayoutX(285);
					        				p1hand.setSpacing(-39);
					        				p1Backs.setSpacing(-20);
						    		        break;
			        						
			        					}        					
			        			}
			        			}
			        			
			        			if(p1hand.getChildren().size()-1 == 9){
			        				p1hand.setLayoutX(260);
			        				p1Backs.setLayoutX(260);
			        				p1hand.setSpacing(-39);
			        				p1Backs.setSpacing(-10);
			        			}
			        			if(p1hand.getChildren().size()-1 == 10){
			        				p1hand.setLayoutX(260);
			        				p1Backs.setLayoutX(260);
			        				p1hand.setSpacing(-39);
			        		        p1Backs.setSpacing(-10);
			        			}
			        			
	    	
	    			  		} catch (Exception e1) {
	    			  			if(e1 instanceof NotEnoughManaException && SFX)
									ManaClip1.play();
								if(e1 instanceof HeroPowerAlreadyUsedException && SFX )
									PowerClip1.play();
	    			  			if(e1 instanceof FullHandException && SFX ){
	    			  				HandClip1.play();
	    			  				Draw.stop();
	    			  			}
	    			  			AlertBox.display("ERROR",e1.getMessage());
	    			  		}
	    			  			verifyMana();
	    			  			verifyHand();
	    			  			verifyHeroHP();
	    			  			verifyDecks();
	    			  			power=false;
	    			  		}
	    		  else  if(player1 instanceof Paladin){
	    			  		if(power == true)
	    			  		try {
								player1.useHeroPower();
								card1 = new AnchorPane();
	    		                card1 = cardcreator(player1.getField().get(player1.getField().size()-1));
	    		                p1field.getChildren().add(card1); 
	    		                if(SFX){
	    		                Summon.play();
	    		                PlaySummon("Silver Hand Recruit");
	    		                }
								verifyField();
	    			  		}
							 catch (Exception e1) {
								if(e1 instanceof NotEnoughManaException && SFX )
									ManaClip1.play();
								if(e1 instanceof HeroPowerAlreadyUsedException  && SFX )
									PowerClip1.play();
								AlertBox.display("ERROR",e1.getMessage());
							}
		    			  		verifyMana();
		    			  		verifyHand();
	    			  			verifyField();
	    			  			power=false;
	    			  		}
	    		  else  if(player1 instanceof Mage){
	    			  if(SFX)
	    			  AttackOn.play();
	    			  SelectYourTargetImageView.setVisible(true);
                      CancelAttackImageView.setVisible(true);
                          Hero1.setEffect(glowAndShadow);;
                          Hero2.setEffect(glowAndShadow);
                              p1field.setEffect(glowAndShadow);
                              p2field.setEffect(glowAndShadow);
                          p1hand.setEffect(colorAdjust);
                          p2hand.setEffect(colorAdjust);
                          Hero1p.setEffect(colorAdjust);
                          Hero2p.setEffect(colorAdjust);
                          End.setEffect(colorAdjust);
                          JainaPower1 = true;
	    			  		Hero2.setOnMouseClicked(s->{
	    			  			if(power == true)
	    			  			try {
									((Mage) player1).useHeroPower(player2);
									if(SFX)
									AttackDone.play();
											
								} catch (Exception e1) {
									AttackDone.stop();
									if(e1 instanceof NotEnoughManaException && SFX )
										ManaClip1.play();
									if(e1 instanceof HeroPowerAlreadyUsedException  && SFX )
										PowerClip1.play();
									AlertBox.display("ERROR",e1.getMessage());
									if(SFX)
									AttackOff.play();
								}
	    			  			
	    			  			Hero1.setEffect(null);
	                            Hero2.setEffect(null);
	                            p1hand.setEffect(null);
	                            p2hand.setEffect(null);
	                            p1field.setEffect(null);
	                            p2field.setEffect(null);
	                            Hero1p.setEffect(null);
	                            Hero2p.setEffect(null);
	                            pic.setEffect(null);
	                            End.setEffect(null);
	                            Hero1p.setDisable(false);
	                            Hero2p.setDisable(false);
	                            p1hand.setDisable(false);
	                            p2hand.setDisable(false);
	                            p1Backs.setDisable(false);
	                            p2Backs.setDisable(false);

	                            SelectYourTargetImageView.setVisible(false);
	                            CancelAttackImageView.setVisible(false);
	    			  			verifyMana();
								verifyHeroHP();
								power=false;
	    			  		});
	    			  		
	    			  		Hero1.setOnMouseClicked(s->{
	    			  			if(power == true)
	    			  			try {
									((Mage) player1).useHeroPower(player1);
									if(SFX)
									AttackDone.play();
											
								} catch (Exception e1) {
									AttackDone.stop();
									if(e1 instanceof NotEnoughManaException && SFX )
										ManaClip1.play();
									if(e1 instanceof HeroPowerAlreadyUsedException  && SFX )
										PowerClip1.play();
									AlertBox.display("ERROR",e1.getMessage());
									if(SFX)
									AttackOff.play();
								}
	    			  			
	    			  			Hero1.setEffect(null);
	                            Hero2.setEffect(null);
	                            p1hand.setEffect(null);
	                            p2hand.setEffect(null);
	                            p1field.setEffect(null);
	                            p2field.setEffect(null);
	                            Hero1p.setEffect(null);
	                            Hero2p.setEffect(null);
	                            pic.setEffect(null);
	                            End.setEffect(null);
	                            Hero1p.setDisable(false);
	                            Hero2p.setDisable(false);
	                            p1hand.setDisable(false);
	                            p2hand.setDisable(false);
	                            p1Backs.setDisable(false);
	                            p2Backs.setDisable(false);

	                            SelectYourTargetImageView.setVisible(false);
	                            CancelAttackImageView.setVisible(false);
	                            
	    			  			verifyMana();
								verifyHeroHP();
								power=false;
	    			  		});
	    			  		
	    		  			}
	    		  else if(player1 instanceof Priest){
	    			  if(SFX)
	    			  AttackOn.play();
	    			  SelectYourTargetImageView.setVisible(true);
                      CancelAttackImageView.setVisible(true);
                      Hero1.setEffect(glowAndShadow);;
                      Hero2.setEffect(glowAndShadow);
                          p1field.setEffect(glowAndShadow);
                          p2field.setEffect(glowAndShadow);
                      p1hand.setEffect(colorAdjust);
                      p2hand.setEffect(colorAdjust);
                      Hero1p.setEffect(colorAdjust);
                      Hero2p.setEffect(colorAdjust);
                      End.setEffect(colorAdjust);
                      AnduinPower1 = true;
	    			  		Hero1.setOnMouseClicked(s->{
	    			  			if(power == true)
	    			  			try {
									((Priest) player1).useHeroPower(player1);
									if(SFX)
									AttackDone.play();						
								} catch (Exception e1) {
									AttackDone.stop();
									if(e1 instanceof NotEnoughManaException && SFX )
										ManaClip1.play();
									if(e1 instanceof HeroPowerAlreadyUsedException  && SFX )
										PowerClip1.play();
									AlertBox.display("ERROR",e1.getMessage());
									if(SFX)
									AttackOff.play();
								}
	    			  			
	    			  			Hero1.setEffect(null);
	                            Hero2.setEffect(null);
	                            p1hand.setEffect(null);
	                            p2hand.setEffect(null);
	                            p1field.setEffect(null);
	                            p2field.setEffect(null);
	                            Hero1p.setEffect(null);
	                            Hero2p.setEffect(null);
	                            pic.setEffect(null);
	                            End.setEffect(null);
	                            Hero1p.setDisable(false);
	                            Hero2p.setDisable(false);
	                            p1hand.setDisable(false);
	                            p2hand.setDisable(false);
	                            p1Backs.setDisable(false);
	                            p2Backs.setDisable(false);

	                            SelectYourTargetImageView.setVisible(false);
	                            CancelAttackImageView.setVisible(false);

	    			  			verifyHeroHP();
								verifyMana();
								power=false;
	    			  		});
	    			  		
	    			  		Hero2.setOnMouseClicked(s->{
	    			  			if(power == true)
	    			  			try {
									((Priest) player1).useHeroPower(player2);
									if(SFX)
									AttackDone.play();
									
								} catch (Exception e1) {
									AttackDone.stop();
									if(e1 instanceof NotEnoughManaException && SFX)
										ManaClip1.play();
									if(e1 instanceof HeroPowerAlreadyUsedException  && SFX )
										PowerClip1.play();
									AlertBox.display("ERROR",e1.getMessage());
									if(SFX)
									AttackOff.play();
								}
	    			  			
	    			  			Hero1.setEffect(null);
	                            Hero2.setEffect(null);
	                            p1hand.setEffect(null);
	                            p2hand.setEffect(null);
	                            p1field.setEffect(null);
	                            p2field.setEffect(null);
	                            Hero1p.setEffect(null);
	                            Hero2p.setEffect(null);
	                            pic.setEffect(null);
	                            End.setEffect(null);
	                            Hero1p.setDisable(false);
	                            Hero2p.setDisable(false);
	                            p1hand.setDisable(false);
	                            p2hand.setDisable(false);
	                            p1Backs.setDisable(false);
	                            p2Backs.setDisable(false);

	                            SelectYourTargetImageView.setVisible(false);
	                            CancelAttackImageView.setVisible(false);
	                            
	    			  			verifyHeroHP();
								verifyMana();
								power=false;
	    			  		});
	    			  		
	    		  				} 			
		        			});     	
		        	Hero2p.setOnMouseClicked(a->{
		        		power=true;
		        		if(player2 instanceof Hunter){
		        			if(power == true)
		        				try {
		        					player2.useHeroPower();
		        					if(SFX)
		        					AttackDone.play();
		        					
		        				} catch (Exception e1) {
		        					AttackDone.stop();
		        					if(e1 instanceof NotEnoughManaException && SFX)
										ManaClip2.play();
		        					if(e1 instanceof HeroPowerAlreadyUsedException && SFX )
										PowerClip2.play();
		        					AlertBox.display("ERROR",e1.getMessage());
		        					if(SFX)
		        					AttackOff.play();
		        					
		        				}
		        				verifyHeroHP();
	        					verifyMana();
	        					power=false;
	        					}
		         else  if(player2 instanceof Warlock){
		        	 		if(power == true)
		        	 			try {
		        	 				player2.useHeroPower();
		        	 				if(SFX)
		        	 				Draw.play();
		        	 				card2 = new AnchorPane();
		        	 				card2 = cardcreator(player2.getHand().get(player2.getHand().size()-1));
		        	 				p2hand.getChildren().add(card2);
		        	 				p2Backs.getChildren().add(backcreator());
		        	 				setHandClickable(player2.getHand().get(player2.getHand().size()-1), card2, player2, p2field,p2hand);
		        	 				
		        	 				if(p2hand.getChildren().size()-1 == 0 && player2.getField().contains("Chromaggus") && player2.getHand().size()>0 ){
					        			p2hand.setLayoutX(780);
					    		        p2Backs.setLayoutX(780);
				        			}
				        			if(p2hand.getChildren().size()-1 == 1){
				        				
				        				p2hand.setLayoutX(590);
					    		        p2Backs.setLayoutX(590);
					    		        p2hand.setSpacing(-20);
					    		       // p2Backs.setSpacing(0);
				        				
				        				for(int i = 0; i < player2.getField().size()-1 && player2.getHand().size()>0 ;i++){
				        					if(player2.getField().get(i).getName().equals("Chromaggus") ){
				        						
				        						p2hand.setLayoutX(660);
							    		        p2Backs.setLayoutX(660);
							    		        break;
				        						
				        					}        					
				        			}
				        		}
				            		if(p2hand.getChildren().size()-1 == 2){
				            			
					        			p2hand.setLayoutX(750);
					    		        p2Backs.setLayoutX(760);
					    		        p2hand.setSpacing(-20);
					    		      //  p2Backs.setSpacing(0);
				            			
					    		        for(int i = 0; i < player2.getField().size()-1 && player2.getHand().size()>0 ;i++){
				        					if(player2.getField().get(i).getName().equals("Chromaggus") ){
				        						
				        						p2hand.setLayoutX(590);
							    		        p2Backs.setLayoutX(590);
							    		        break;
				        						
				        					}        					
				        			}
				        			}
				        			
				        			if(p2hand.getChildren().size()-1 == 3){
				        				
					        			p2hand.setLayoutX(640);
					    		        p2Backs.setLayoutX(660);
					    		        p2hand.setSpacing(-20);
					    		       // p2Backs.setSpacing(0);
					    		        p1Backs.setLayoutX(600);
					    		        
					    		        for(int i = 0; i < player2.getField().size()-1 && player2.getHand().size()>0 ;i++){
				        					if(player2.getField().get(i).getName().equals("Chromaggus") ){
				        						
				        						p2hand.setLayoutX(505);
							    		        p2Backs.setLayoutX(505);
							    		        break;
				        						
				        					}        					
				        			}
					    		        
				        				}
				        			
				        			if(p2hand.getChildren().size()-1 == 4){


					        			p2hand.setLayoutX(530);
					    		        p2Backs.setLayoutX(530);
					    		        p2hand.setSpacing(-20);
					    		      //  p2Backs.setSpacing(0);
					    		        
					    		        for(int i = 0; i < player2.getField().size()-1 && player2.getHand().size()>0 ;i++){
				        					if(player2.getField().get(i).getName().equals("Chromaggus")){
				        						
				        						p2hand.setLayoutX(450);
							    		        p2Backs.setLayoutX(450);
							    		        break;
				        						
				        					}        					
				        			}
				        				}
				        			
				        			if(p2hand.getChildren().size()-1 == 5){
				        				
					        			p2hand.setLayoutX(500);
					    		        p2Backs.setLayoutX(500);
					    		        p2hand.setSpacing(-20);
					    		      //  p2Backs.setSpacing(0);
				        				
					    		        for(int i = 0; i < player2.getField().size()-1 && player2.getHand().size()>0 ;i++){
				        					if(player2.getField().get(i).getName().equals("Chromaggus")){
				        						
				        						p2hand.setLayoutX(370);
							    		        p2Backs.setLayoutX(370);
							    		        break;
				        						
				        					}        					
				        			}
				        			}
				        			if(p2hand.getChildren().size()-1 == 6){
				        				
					        			p2hand.setLayoutX(410);
					    		        p2Backs.setLayoutX(410);
					    		        p2hand.setSpacing(-20);
					    		       // p2Backs.setSpacing(3);
				        				
					    		        for(int i = 0; i < player2.getField().size()-1 && player2.getHand().size()>0 ;i++){
				        					if(player2.getField().get(i).getName().equals("Chromaggus")){
				        						
				        						p2hand.setLayoutX(335);
							    		        p2Backs.setLayoutX(335);
							    		        break;
				        						
				        					}        					
				        			}
				        			}
				        			if(p2hand.getChildren().size()-1 == 7){
				        				
					        			p2hand.setLayoutX(340);
					    		        p2Backs.setLayoutX(340);
					    		        p2hand.setSpacing(-20);
					    		       // p2Backs.setSpacing(0);
				        				
					    		        for(int i = 0; i < player2.getField().size() -1&& player2.getHand().size()>0 ;i++){
				        					if(player2.getField().get(i).getName().equals("Chromaggus")){
				        						
				        						p2hand.setLayoutX(267);
						        				p2Backs.setLayoutX(267);
						        				p2Backs.setSpacing(0);
							    		        break;
				        						
				        					}        					
				        			}
				        			}
				        			if(p2hand.getChildren().size() -1== 8){
				        				
					        			p2hand.setLayoutX(260);
					    		        p2Backs.setLayoutX(260);
					    		        p2Backs.setSpacing(5.5);
					    		       // p2hand.setSpacing(-20);
				        				
					    		        for(int i = 0; i < player2.getField().size()-1 && player2.getHand().size()>0 ;i++){
				        					if(player2.getField().get(i).getName().equals("Chromaggus")){
				        						
				        						p2hand.setLayoutX(285);
						        				p2Backs.setLayoutX(285);
						        				p2hand.setSpacing(-39);
						        				p2Backs.setSpacing(-10);
							    		        break;
				        						
				        					}        					
				        			}
				        			}
				        			
				        			if(p2hand.getChildren().size()-1 == 9){
				        				p2hand.setLayoutX(260);
				        				p2Backs.setLayoutX(260);
				        				p2hand.setSpacing(-39);
				        				p2Backs.setSpacing(-10);
				        			}
				        			if(p2hand.getChildren().size() -1== 10){
				        				p2hand.setLayoutX(260);
				        				p1Backs.setLayoutX(260);
				        				p2hand.setSpacing(-39);
				        		        p2Backs.setSpacing(-10);
				        			}
		        	 				
		        	 			} catch (Exception e1) {
		        	 				if(e1 instanceof NotEnoughManaException && SFX )
										ManaClip2.play();
									if(e1 instanceof HeroPowerAlreadyUsedException && SFX )
										PowerClip2.play();
		        	 				if(e1 instanceof FullHandException && SFX ){
		        	 					HandClip2.play();
		        	 					Draw.stop();
		        	 				}
		        	 				
		        	 				AlertBox.display("ERROR",e1.getMessage());
		        	 			}
		        	 			verifyMana();
	        	 				verifyHeroHP();
	        	 				verifyHand();
	        	 				verifyDecks();
	        	 				power=false;
	        	 				}
			   else  if(player2 instanceof Paladin){
				   			if(power == true)
				   				try {
				   					player2.useHeroPower();
				   					card2 = new AnchorPane();
				   					card2 = cardcreator(player2.getField().get(player2.getField().size()-1));
				   					p2field.getChildren().add(card2); 
				   					if(SFX){
				   					Summon.play();
				   					PlaySummon("Silver Hand Recruit");
				   					}
				   				} catch (Exception e1) {
				   					if(e1 instanceof NotEnoughManaException && SFX )
										ManaClip2.play();
									if(e1 instanceof HeroPowerAlreadyUsedException  && SFX)
										PowerClip2.play();
				   					AlertBox.display("ERROR",e1.getMessage());
				   				}
				   				verifyMana();
			   					verifyHand();
			   					verifyField();
			   					power=false;
				   				}
			  else  if(player2 instanceof Mage){
				  if(SFX)
				  AttackOn.play();
				  SelectYourTargetImageView.setVisible(true);
                  CancelAttackImageView.setVisible(true);
                      Hero1.setEffect(glowAndShadow);;
                      Hero2.setEffect(glowAndShadow);
                          p1field.setEffect(glowAndShadow);
                          p2field.setEffect(glowAndShadow);
                      p1hand.setEffect(colorAdjust);
                      p2hand.setEffect(colorAdjust);
                      Hero1p.setEffect(colorAdjust);
                      Hero2p.setEffect(colorAdjust);
                      End.setEffect(colorAdjust);
                      JainaPower2 = true;
				  		Hero1.setOnMouseClicked(s->{
				  			if(power == true)
				  				try {
				  					((Mage) player2).useHeroPower(player1);
				  					if(SFX)
				  					AttackDone.play();
				  					
				  				} catch (Exception e1) {
				  					AttackDone.stop();
				  					if(e1 instanceof NotEnoughManaException && SFX)
										ManaClip2.play();
									if(e1 instanceof HeroPowerAlreadyUsedException  && SFX )
										PowerClip2.play();
				  					AlertBox.display("ERROR",e1.getMessage());
				  					if(SFX)
				  					AttackOff.play();
				  				}
				  			
				  			Hero1.setEffect(null);
                            Hero2.setEffect(null);
                            p1hand.setEffect(null);
                            p2hand.setEffect(null);
                            p1field.setEffect(null);
                            p2field.setEffect(null);
                            Hero1p.setEffect(null);
                            Hero2p.setEffect(null);
                            pic.setEffect(null);
                            End.setEffect(null);
                            Hero1p.setDisable(false);
                            Hero2p.setDisable(false);
                            p1hand.setDisable(false);
                            p2hand.setDisable(false);
                            p1Backs.setDisable(false);
                            p2Backs.setDisable(false);

                            SelectYourTargetImageView.setVisible(false);
                            CancelAttackImageView.setVisible(false);
				  				verifyMana();
			  					verifyHeroHP();
			  					power=false;
				  		});
				  		
				  		Hero2.setOnMouseClicked(s->{
				  			if(power == true)
				  				try {
				  					((Mage) player2).useHeroPower(player2);
				  					if(SFX)
				  					AttackDone.play();
				  					
				  				} catch (Exception e1) {
				  					AttackDone.stop();
				  					if(e1 instanceof NotEnoughManaException && SFX )
										ManaClip2.play();
									if(e1 instanceof HeroPowerAlreadyUsedException  && SFX)
										PowerClip2.play();
				  					AlertBox.display("ERROR",e1.getMessage());
				  					if(SFX)
				  					AttackOff.play();
				  				}
				  			Hero1.setEffect(null);
                            Hero2.setEffect(null);
                            p1hand.setEffect(null);
                            p2hand.setEffect(null);
                            p1field.setEffect(null);
                            p2field.setEffect(null);
                            Hero1p.setEffect(null);
                            Hero2p.setEffect(null);
                            pic.setEffect(null);
                            End.setEffect(null);
                            Hero1p.setDisable(false);
                            Hero2p.setDisable(false);
                            p1hand.setDisable(false);
                            p2hand.setDisable(false);
                            p1Backs.setDisable(false);
                            p2Backs.setDisable(false);

                            SelectYourTargetImageView.setVisible(false);
                            CancelAttackImageView.setVisible(false);
				  				verifyMana();
			  					verifyHeroHP();
			  					power=false;
				  		});
				  		
			  		}
			  else if(player2 instanceof Priest){
				  if(SFX)
				  AttackOn.play();
				  SelectYourTargetImageView.setVisible(true);
                  CancelAttackImageView.setVisible(true);
                      Hero1.setEffect(glowAndShadow);;
                      Hero2.setEffect(glowAndShadow);
                          p1field.setEffect(glowAndShadow);
                          p2field.setEffect(glowAndShadow);
                      p1hand.setEffect(colorAdjust);
                      p2hand.setEffect(colorAdjust);
                      Hero1p.setEffect(colorAdjust);
                      Hero2p.setEffect(colorAdjust);
                      End.setEffect(colorAdjust);
                      AnduinPower2 = true;
				  		Hero2.setOnMouseClicked(s->{
				  			if(power == true)
				  			try {
								((Priest) player2).useHeroPower(player2);
								if(SFX)
								AttackDone.play();
								
							} catch (Exception e1) {
								AttackDone.stop();
								if(e1 instanceof NotEnoughManaException && SFX )
									ManaClip2.play();
								if(e1 instanceof HeroPowerAlreadyUsedException  && SFX )
									PowerClip2.play();
								AlertBox.display("ERROR",e1.getMessage());
								if(SFX)
								AttackOff.play();
							}
				  			
				  			Hero1.setEffect(null);
                            Hero2.setEffect(null);
                            p1hand.setEffect(null);
                            p2hand.setEffect(null);
                            p1field.setEffect(null);
                            p2field.setEffect(null);
                            Hero1p.setEffect(null);
                            Hero2p.setEffect(null);
                            pic.setEffect(null);
                            End.setEffect(null);
                            Hero1p.setDisable(false);
                            Hero2p.setDisable(false);
                            p1hand.setDisable(false);
                            p2hand.setDisable(false);
                            p1Backs.setDisable(false);
                            p2Backs.setDisable(false);

                            SelectYourTargetImageView.setVisible(false);
                            CancelAttackImageView.setVisible(false);
				  			verifyHeroHP();
							verifyMana();
							power=false;
				 			});
				  		
				  		Hero1.setOnMouseClicked(s->{
				  			if(power == true)
				  			try {
								((Priest) player2).useHeroPower(player1);
								if(SFX)
								AttackDone.play();
								
							} catch (Exception e1) {
								AttackDone.stop();
								if(e1 instanceof NotEnoughManaException && SFX )
									ManaClip2.play();
								if(e1 instanceof HeroPowerAlreadyUsedException  && SFX )
									PowerClip2.play();
								AlertBox.display("ERROR",e1.getMessage());
								if(SFX)
								AttackOff.play();
							}
				  			
				  			Hero1.setEffect(null);
                            Hero2.setEffect(null);
                            p1hand.setEffect(null);
                            p2hand.setEffect(null);
                            p1field.setEffect(null);
                            p2field.setEffect(null);
                            Hero1p.setEffect(null);
                            Hero2p.setEffect(null);
                            pic.setEffect(null);
                            End.setEffect(null);
                            Hero1p.setDisable(false);
                            Hero2p.setDisable(false);
                            p1hand.setDisable(false);
                            p2hand.setDisable(false);
                            p1Backs.setDisable(false);
                            p2Backs.setDisable(false);

                            SelectYourTargetImageView.setVisible(false);
                            CancelAttackImageView.setVisible(false);
				  			verifyHeroHP();
							verifyMana();
							power=false;
				 			});
			  	}				
		        		});	
						}
			Image Hero1Big ;
            Hero1Big = null;

            Hero1BigView = new ImageView();
            if(player1.getName().equals("Gul'dan"))
                Hero1Big = new Image(getClass().getResourceAsStream("Guldan.png"));
            else Hero1Big = new Image(getClass().getResourceAsStream(player1.getName()+".png"));
                Hero1BigView = new ImageView(Hero1Big);


            Hero1.setOnMouseEntered(a -> {

                Hero1.setEffect(glowAndShadow);

                Hero1LabelView = new Label(HeroHealth1.getText());
                Hero1LabelView.setTextFill(Color.WHITE);
                Hero1LabelView.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
                Hero1LabelView.setLayoutX(228);
                Hero1LabelView.setLayoutY(605);


                Hero1BigView.setX(-10);
                Hero1BigView.setY(340);
                Hero1BigView.setFitHeight(510);
                Hero1BigView.setFitWidth(305);
                Hero1BigView.setPreserveRatio(true);


                window.getChildren().addAll(Hero1BigView, Hero1LabelView);
                

            });

            Hero1.setOnMouseExited(a -> {
                window.getChildren().removeAll(Hero1BigView, Hero1LabelView);
                if(attacking == false)
                	Hero1.setEffect(null);

            });
            Image Hero2Big ;
            Hero2Big = null;

            Hero2BigView = new ImageView();
            if(player2.getName().equals("Gul'dan"))
                Hero2Big = new Image(getClass().getResourceAsStream("Guldan.png"));
            else Hero2Big = new Image(getClass().getResourceAsStream(player2.getName()+".png"));
            Hero2BigView = new ImageView(Hero2Big);


           Hero2.setOnMouseEntered(a -> {

                Hero2.setEffect(glowAndShadow);

                Hero2LabelView = new Label(HeroHealth2.getText());
                Hero2LabelView.setTextFill(Color.WHITE);
                Hero2LabelView.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
                Hero2LabelView.setLayoutX(228);
                Hero2LabelView.setLayoutY(605);


                Hero2BigView.setX(-10);
                Hero2BigView.setY(340);
                Hero2BigView.setFitHeight(510);
                Hero2BigView.setFitWidth(305);
                Hero2BigView.setPreserveRatio(true);


                window.getChildren().addAll(Hero2BigView, Hero2LabelView);

            });

            Hero2.setOnMouseExited(a -> {
            	
                window.getChildren().removeAll(Hero2BigView, Hero2LabelView);
                if(attacking == false)
                	Hero2.setEffect(null);

            });
            window.getChildren().addAll(SelectYourTargetImageView, CancelAttackImageView); 
    	});
    	
    		
        	primaryStage.show();
	}
	
	public void playSound(String path) throws IOException, LineUnavailableException{
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Sounds/PUBG.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private Label heroMana(Hero p) {
	    Mana = new Label();
        CMana = new SimpleIntegerProperty(p.getCurrentManaCrystals());
	    CManaB = new SimpleIntegerProperty();
	    CManaB.bind(CMana);
	    TMana = new SimpleIntegerProperty(p.getTotalManaCrystals());
	    TManaB = new SimpleIntegerProperty();
	    TManaB.bind(TMana);
	    Mana = new Label();
	    Mana.setTextFill(Color.WHITE);
	    Mana.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
	    Mana.setText(""+CManaB.getValue().intValue()+"/"+TManaB.getValue().intValue());
		return Mana;
	}
	private Label heroHP(Hero p){
		HeroHealth = new Label();
        HeroHP = new SimpleIntegerProperty(p.getCurrentHP());
	    HeroHPB = new SimpleIntegerProperty();
	    HeroHPB.bind(HeroHP);
	    HeroHealth.setText(""+HeroHPB.getValue().intValue());
	    HeroHealth.setTextFill(Color.WHITE);
	    HeroHealth.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));
		return HeroHealth;
	}

	private AnchorPane createHerop(Hero p) {
		herop = new AnchorPane();
		Image img = null;
		if(p.getName().equals("Rexxar"))
			img = new Image(getClass().getResourceAsStream("Steady Shot.png"));
		else if(p.getName().equals("Jaina Proudmoore"))
			img = new Image(getClass().getResourceAsStream("Fireblast.png"));
		else if(p.getName().equals("Uther Lightbringer"))
			img = new Image(getClass().getResourceAsStream("Reinforce.png"));
		else if(p.getName().equals("Gul'dan"))
			img = new Image(getClass().getResourceAsStream("Life Tap.png"));
		else if(p.getName().equals("Anduin Wrynn"))
			img = new Image(getClass().getResourceAsStream("Lesser Heal.png"));
		ImageView pic = new ImageView(img);
		pic.setFitHeight(img.getHeight()-200);
	    pic.setFitWidth(img.getWidth()-200);
	    pic.setPreserveRatio(true);
	    herop.setPrefHeight(img.getHeight());
	    herop.setMaxSize(img.getWidth()-225,img.getHeight()-225);
	    herop.setPrefWidth(img.getWidth());
	    herop.getChildren().add(pic);
	    ImageView BigHeroPower = new ImageView(img);
	    pic.setOnMouseEntered(e ->{
	    	
	    	pic.setEffect(glowAndShadow);
	    	BigHeroPower.setX(10);
	    	BigHeroPower.setY(300);
	    	BigHeroPower.setFitHeight(470);
	    	BigHeroPower.setFitWidth(270);
	    	BigHeroPower.setPreserveRatio(true);
	    	herop.getChildren().add(BigHeroPower);
	    	
	    });
	    
	    pic.setOnMouseExited(e ->{
	    	
	    	pic.setEffect(null);
	    	herop.getChildren().remove(BigHeroPower);
	    	
	    });
	    
		return herop;
	}
	private AnchorPane createHero(Hero p) {
		hero = new AnchorPane();
		Image img = null;
		if(p.getName().equals("Gul'dan"))
			img = new Image(getClass().getResourceAsStream("Guldan.png"));	
		else img = new Image(getClass().getResourceAsStream(p.getName()+".png"));
		ImageView pic = new ImageView(img);
		pic.setFitHeight(img.getHeight());
	    pic.setFitWidth(img.getWidth());
	    pic.setPreserveRatio(true);
	    hero.setPrefHeight(img.getHeight());
	    hero.setMaxSize(img.getWidth()-225,img.getHeight()-225);
	    hero.setPrefWidth(img.getWidth());
	    hero.getChildren().add(pic);
	    pic.setFitHeight(img.getHeight()-175);
	    pic.setFitWidth(img.getWidth()-175);
	   
		return hero;
	}
	
	void verifyMana(){
		Mana1.setText(""+player1.getCurrentManaCrystals()+"/"+player1.getTotalManaCrystals());
        Mana2.setText(""+player2.getCurrentManaCrystals()+"/"+player2.getTotalManaCrystals());
        if(player1.getCurrentManaCrystals()==10&&player1.getTotalManaCrystals()==10){
            Mana1.setLayoutX(190);
            Mana1.setLayoutY(812);
            Mana1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        }
        else if(player1.getCurrentManaCrystals()<10&&player1.getTotalManaCrystals()==10) {
            Mana1.setLayoutX(196);
            Mana1.setLayoutY(812);
            Mana1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        }
        else{
        	Mana1.setLayoutX(199);
        	Mana1.setLayoutY(812);
        }
        if(player2.getCurrentManaCrystals()==10&&player2.getTotalManaCrystals()==10){
            Mana2.setLayoutX(1667);
            Mana2.setLayoutY(240);
            Mana2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        }
        else if(player2.getCurrentManaCrystals()<10&&player2.getTotalManaCrystals()==10) {
            Mana2.setLayoutX(1677);
            Mana2.setLayoutY(240);
            Mana2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        }
        
        else{
        	Mana2.setLayoutX(1680);
	        Mana2.setLayoutY(240);
        }
	}
	void verifyHand(){
    	int b=0;
    	p1hand.getChildren().clear();
    	p2hand.getChildren().clear();
    	p1Backs.getChildren().clear();
    	p2Backs.getChildren().clear();
    	while(b<player1.getHand().size()&&player1.getHand().get(player1.getHand().size()-1)!=null){
    		p1Backs.getChildren().add(backcreator());
    		card1 = new AnchorPane();
            card1 = cardcreator(player1.getHand().get(b));
            p1hand.getChildren().add(card1);
            setHandClickable(player1.getHand().get(b), card1, player1, p1field,p1hand);
            if(player1.getHand().get(b) instanceof LeechingSpell || 
            	player1.getHand().get(b) instanceof MinionTargetSpell)
            	setFieldClickable(player1.getHand().get(b), (AnchorPane) p1hand.getChildren().get(b));
    		b++;
    	}
    	int d=0;
    	while(d<player2.getHand().size()&&player2.getHand().get(player2.getHand().size()-1)!=null){
    		p2Backs.getChildren().add(backcreator());
    		card2 = new AnchorPane();
            card2 = cardcreator(player2.getHand().get(d));
            p2hand.getChildren().add(card2);
            setHandClickable(player2.getHand().get(d), card2, player2, p2field,p2hand);
            if(player2.getHand().get(d) instanceof LeechingSpell || 
                	player2.getHand().get(d) instanceof MinionTargetSpell)
                	setFieldClickable(player2.getHand().get(d), (AnchorPane) p2hand.getChildren().get(d));
    		d++;
    	}
    	
	}
	void verifyField(){
		int i=0;
		int j=0;
		p1field.getChildren().clear();
		p2field.getChildren().clear();
		while(i<player1.getField().size()){
			p1field.getChildren().add(cardcreator(player1.getField().get(i)));
			setFieldClickable(player1.getField().get(i),(AnchorPane) p1field.getChildren().get(i));
			i++;
		}
		while(j<player2.getField().size()){
			p2field.getChildren().add(cardcreator(player2.getField().get(j)));
			setFieldClickable(player2.getField().get(j),(AnchorPane) p2field.getChildren().get(j));
			j++;
		}
	}
	
	void setFieldClickable(Card c, AnchorPane card){
		
		Image BigImage = null;
		if(!c.getName().equals("Shadow Word: Death"))
			BigImage = new Image(getClass().getResourceAsStream(c.getName()+".png"));
		else  BigImage = new Image(getClass().getResourceAsStream("Shadow Word Death.png"));
		    ImageView BigImageView = new ImageView(BigImage);
		
		
		BigImageView.setX(1);
		BigImageView.setY(360);
		BigImageView.setFitHeight(470);
		BigImageView.setFitWidth(278);
		BigImageView.setPreserveRatio(true);
		
		
		Image divine = new Image(getClass().getResourceAsStream("shield.png"));
		ImageView BigDivinity = new ImageView(divine);
		BigDivinity.setX(35);
		BigDivinity.setY(353);
		BigDivinity.setFitHeight(430);
		BigDivinity.setFitWidth(220);
		
		
		BigDivinity.setPreserveRatio(true);
	    
		Label BigMana = new Label(""+c.getManaCost());
		BigMana.setTextFill(Color.WHITE);
		BigMana.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
		BigMana.setLayoutX(36);
		BigMana.setLayoutY(377);
		Label BigAttack = new Label();
		Label BigHP = new Label();
		
		BigAttack.setTextFill(Color.WHITE);
		BigAttack.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
		BigAttack.setLayoutX(36);
		BigAttack.setLayoutY(675);
		BigHP.setTextFill(Color.WHITE);
	    BigHP.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
	    BigHP.setLayoutX(235);
	    BigHP.setLayoutY(678);
	    
        if(c instanceof Minion && c.getRarity().equals(Rarity.LEGENDARY)&&c.getManaCost()>=10){
        	BigMana.setLayoutX(26);
    		BigMana.setLayoutY(398);
        }
        else if(c instanceof Minion && c.getRarity().equals(Rarity.LEGENDARY)&&c.getManaCost()<10){
        	BigMana.setLayoutX(36);
    		BigMana.setLayoutY(394);
        }
        else if(c instanceof Spell && c.getManaCost()>=10){
        	BigMana.setLayoutX(26);
    		BigMana.setLayoutY(398);
        }

   
		
		card.setOnMouseEntered(a->{
			
			if(attacking == false)
				card.setEffect(glowAndShadow);
			
			window.getChildren().addAll(BigImageView ,BigMana);	
		
			if(c instanceof Minion){
				
				BigAttack.setText(""+(((Minion) c).getAttack()));
				BigHP.setText(""+((Minion) c).getCurrentHP());
				
				 if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getCurrentHP()>=10){
			        	BigHP.setLayoutX(221);
			        	BigHP.setLayoutY(698);
			       }
			       else if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getCurrentHP()<10){
			    	   BigHP.setLayoutX(235);
			    	   BigHP.setLayoutY(695);
			           }
			        
			        
			        if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getAttack()>=10){
			        	BigAttack.setLayoutX(28);
			        	BigAttack.setLayoutY(695);
			   }
			   	else if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getAttack()<10){
			   			BigAttack.setLayoutX(35);
			   			BigAttack.setLayoutY(695);
			        }

			   	if(((Minion) c).isDivine()){
			   		BigDivinity.setY(350);
			    }

				window.getChildren().addAll(BigAttack, BigHP);
				
				if((((Minion)c).isDivine())){
					window.getChildren().add(BigDivinity);
				}
			}
			
			if(player1.getHand().contains(c) || player2.getHand().contains(c) || player1.getHand().contains(attacker) || player2.getHand().contains(attacker)){
			
				timeline5 = new Timeline();
				kv5 = new KeyValue(card.translateYProperty(),-28,Interpolator.EASE_IN);
				kf5 = new KeyFrame(Duration.seconds(0.1), kv5);
				timeline5.getKeyFrames().add(kf5);
				timeline5.play();
				
			}  	
			
		});
		
		card.setOnMouseExited(a -> {
			
			if(attacking == false)
				card.setEffect(null);
			
			window.getChildren().removeAll(BigImageView, BigMana);
			if(c instanceof Minion){
				window.getChildren().removeAll(BigAttack, BigHP);
				
				if((((Minion)c).isDivine())){
					window.getChildren().remove(BigDivinity);
				}
			}
			
			if(player1.getHand().contains(c) || player2.getHand().contains(c) || player1.getHand().contains(attacker) || player2.getHand().contains(attacker)){
				
				timeline6 = new Timeline();
				kv6 = new KeyValue(card.translateYProperty(),0,Interpolator.EASE_IN);
				kf6 = new KeyFrame(Duration.seconds(0.1), kv6);
				timeline6.getKeyFrames().add(kf6);
				timeline6.play();
				
			}
			
		});
	
		
		card.setOnMouseClicked(e->{
			if(SFX)
			AttackOn.play();
			if(c instanceof Minion){
				   
	   			Hero1.setOnMouseClicked(a->{
	   				try {
						game.getCurrentHero().attackWithMinion((Minion)c, player1);
						if(SFX){
						AttackDone.play();
						PlayAttack(c.getName());
						}
					} catch (Exception e1) {
						AttackDone.stop();
						if(e1.getMessage().contains("Minion is Sleeping")&& SFX  && game.getCurrentHero()==player1)
							SleepingClip1.play();
						if(e1.getMessage().contains("Minion is Sleeping")&& SFX  && game.getCurrentHero()==player2)
							SleepingClip2.play();
						if(e1.getMessage().contains("Minion attacked once this turn")&& SFX  && game.getCurrentHero()==player1)
							AttackedClip1.play();
						if(e1.getMessage().contains("Minion attacked once this turn")&& SFX  && game.getCurrentHero()==player2)
							AttackedClip2.play();
						if((e1 instanceof InvalidTargetException || e1 instanceof NotSummonedException) && SFX && game.getCurrentHero()==player1 )
							InvalidClip1.play();
						if(e1 instanceof TauntBypassException && SFX  && game.getCurrentHero()==player1)
							TauntClip1.play();
						if(e1 instanceof TauntBypassException && SFX  && game.getCurrentHero()==player2)
							TauntClip2.play();
						AlertBox.display("Error",e1.getMessage());
						if(SFX)
						AttackOff.play();
						attacking = false;
			    		attacker = null;
			    		
			    		SelectYourTargetImageView.setVisible(false);
			    		CancelAttackImageView.setVisible(false);
			    		
					}
	   				attacking = false;
	   				verifyHeroHP();
	   				verifyField();
	   				
	   				Hero1.setOnMouseClicked(x->{
                        x.consume();
                    });
                    Hero2.setOnMouseClicked(y->{
                        y.consume();
                    });
	   				
	   				Hero1.setEffect(null);
					Hero2.setEffect(null);
					p1hand.setEffect(null);
					p2hand.setEffect(null);
					p1field.setEffect(null);
					p2field.setEffect(null);
					card.setEffect(null);
					Hero1p.setEffect(null);
					Hero2p.setEffect(null);
					pic.setEffect(null);
					End.setEffect(null);
					p1hand.setDisable(false);
					p2hand.setDisable(false);
					Hero1p.setDisable(false);
					Hero2p.setDisable(false);
					p1Backs.setDisable(false);
					p2Backs.setDisable(false);
					
					SelectYourTargetImageView.setVisible(false);
					CancelAttackImageView.setVisible(false);
					return;
	   			});
	   			Hero2.setOnMouseClicked(b->{
	   				try {
						game.getCurrentHero().attackWithMinion((Minion)c, player2);
						if(SFX){
						AttackDone.play();
						PlayAttack(c.getName());
						}
					} catch (Exception e1) {
						AttackDone.stop();
						if(e1.getMessage().contains("Minion is Sleeping")&& SFX && game.getCurrentHero()==player1)
							SleepingClip1.play();
						if(e1.getMessage().contains("Minion is Sleeping")&& SFX && game.getCurrentHero()==player2)
							SleepingClip2.play();
						if(e1.getMessage().contains("Minion attacked once this turn")&& SFX  && game.getCurrentHero()==player1)
							AttackedClip1.play();
						if(e1.getMessage().contains("Minion attacked once this turn")&& SFX  && game.getCurrentHero()==player2)
							AttackedClip2.play();
						if((e1 instanceof InvalidTargetException || e1 instanceof NotSummonedException) && SFX )
							InvalidClip2.play();
						if(e1 instanceof TauntBypassException&& SFX  && game.getCurrentHero()==player1)
							TauntClip1.play();
						if(e1 instanceof TauntBypassException&& SFX  && game.getCurrentHero()==player2)
							TauntClip2.play();
						AlertBox.display("Error",e1.getMessage());
						if(SFX)
						AttackOff.play();
						attacking = false;
			    		attacker = null;
						
			    		SelectYourTargetImageView.setVisible(false);
			    		CancelAttackImageView.setVisible(false);
			    		
					}
	   				
	   				Hero1.setOnMouseClicked(x->{
                        x.consume();
                    });
                    Hero2.setOnMouseClicked(y->{
                        y.consume();
                    });
	   				
	   				attacking=false;
	   				verifyHeroHP();
	   				verifyField();
					Hero1.setEffect(null);
					Hero2.setEffect(null);
					p1hand.setEffect(null);
					p2hand.setEffect(null);
					p1field.setEffect(null);
					p2field.setEffect(null);
					card.setEffect(null);
					Hero1p.setEffect(null);
					Hero2p.setEffect(null);
					pic.setEffect(null);
					End.setEffect(null);
					p1hand.setDisable(false);
					p2hand.setDisable(false);
					Hero1p.setDisable(false);
					Hero2p.setDisable(false);
					p1Backs.setDisable(false);
					p2Backs.setDisable(false);
					
					SelectYourTargetImageView.setVisible(false);
					CancelAttackImageView.setVisible(false);
					return;
	   			});
	   	}
			
			 if(c instanceof HeroTargetSpell){
				  
				   Hero1.setOnMouseClicked(a->{
					try {
						game.getCurrentHero().castSpell((HeroTargetSpell)c, player1);
						if(SFX)
						SpellCast.play();
						if(p1hand.isVisible()){
            				
            				if(p1hand.getChildren().size() == 1){
    		        			p1hand.setLayoutX(1030);
    		    		        p1Backs.setLayoutX(1030);
    	        			}
    	            		if(p1hand.getChildren().size() == 2){
    		        			p1hand.setLayoutX(940);
    		    		        p1Backs.setLayoutX(940);
    	        			}
    	        			
    	        			if(p1hand.getChildren().size() == 3){
    		        			p1hand.setLayoutX(850);
    		    		        p1Backs.setLayoutX(850);
    	        			}
    	        			if(p1hand.getChildren().size() == 4){
    		        			p1hand.setLayoutX(760);
    		    		        p1Backs.setLayoutX(760);
    	        			}
    	        			if(p1hand.getChildren().size() == 5){
    		        			p1hand.setLayoutX(670);
    		    		        p1Backs.setLayoutX(670);
    	        			}
    	        			if(p1hand.getChildren().size() == 6){
    		        			p1hand.setLayoutX(580);
    		    		        p1Backs.setLayoutX(580);
    	        			}
    	        			if(p1hand.getChildren().size() == 7){
    		        			p1hand.setLayoutX(490);
    		    		        p1Backs.setLayoutX(490);
    	        			}
    	        			if(p1hand.getChildren().size() == 8){
    		        			p1hand.setLayoutX(400);
    		    		        p1Backs.setLayoutX(405);	
    	        			}
    	        			
    	        			if(p1hand.getChildren().size() == 9){
    	        				p1hand.setLayoutX(330);
    	        				p1Backs.setLayoutX(400);
    	        			}
    	        			if(p1hand.getChildren().size() == 10){
    	        				p1hand.setLayoutX(250);
    	        				p1Backs.setLayoutX(280);
    	        				p1hand.setSpacing(-20);
    	        				p1Backs.setSpacing(0);
    	        			}
            				
            			}
            			
	        			
	        			//for player2
	        			if(p2hand.isVisible()){
	        				
	        				if(p2hand.getChildren().size() == 1){
			        			p2hand.setLayoutX(1030);
			    		        p2Backs.setLayoutX(1030);
		        			}
		            		if(p2hand.getChildren().size() == 2){
			        			p2hand.setLayoutX(940);
			    		        p2Backs.setLayoutX(940);
		        			}
		        			
		        			if(p2hand.getChildren().size() == 3){
			        			p2hand.setLayoutX(850);
			    		        p2Backs.setLayoutX(850);
		        			}
		        			if(p2hand.getChildren().size() == 4){
			        			p2hand.setLayoutX(760);
			    		        p2Backs.setLayoutX(760);
		        			}
		        			if(p2hand.getChildren().size() == 5){
			        			p2hand.setLayoutX(670);
			    		        p2Backs.setLayoutX(670);
		        			}
		        			if(p2hand.getChildren().size() == 6){
			        			p2hand.setLayoutX(580);
			    		        p2Backs.setLayoutX(580);
		        			}
		        			if(p2hand.getChildren().size() == 7){
			        			p2hand.setLayoutX(490);
			    		        p2Backs.setLayoutX(490);
		        			}
		        			if(p2hand.getChildren().size() == 8){
			        			p2hand.setLayoutX(400);
			    		        p2Backs.setLayoutX(405);	
		        			}
		        			
		        			if(p2hand.getChildren().size() == 9){
		        				p2hand.setLayoutX(330);
		        				p2Backs.setLayoutX(400);
		        			}
		        			if(p2hand.getChildren().size() == 10){
		        				p2hand.setLayoutX(250);
		        				p2Backs.setLayoutX(280);
		        				p2hand.setSpacing(-20);
		        				p2Backs.setSpacing(0);
		        			}
	        				
	        			}
						
						
					} catch (Exception e1) {
						SpellCast.stop();
						if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player1 )
							ManaClip1.play();
						if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player2 )
							ManaClip2.play();
						AlertBox.display("Error", e1.getMessage());
						if(SFX)
						AttackOff.play();
						attacking = false;			
					}
					
					Hero1.setOnMouseClicked(x->{
		                x.consume();
		            });
		            Hero2.setOnMouseClicked(y->{
		                y.consume();
		            });
					
        			Hero1.setEffect(null);
					Hero2.setEffect(null);
					p1hand.setEffect(null);
					p2hand.setEffect(null);
					p1field.setEffect(null);
					p2field.setEffect(null);
					Hero1p.setEffect(null);
					Hero2p.setEffect(null);
					pic.setEffect(null);
					End.setEffect(null);
					p1hand.setDisable(false);
					p2hand.setDisable(false);
					Hero1p.setDisable(false);
					Hero2p.setDisable(false);
    					
    				SelectYourTargetImageView.setVisible(false);
    				CancelAttackImageView.setVisible(false);
        			attacking = false;
        			attacker = null;
        			
					verifyHeroHP();
					verifyMana();
					verifyHand();
					return;
		
				   });
				   Hero2.setOnMouseClicked(a->{
						try {
							game.getCurrentHero().castSpell((HeroTargetSpell)c, player2);
							if(SFX)
							SpellCast.play();
							if(p1hand.isVisible()){
	            				
	            				if(p1hand.getChildren().size() == 1){
	    		        			p1hand.setLayoutX(1030);
	    		    		        p1Backs.setLayoutX(1030);
	    	        			}
	    	            		if(p1hand.getChildren().size() == 2){
	    		        			p1hand.setLayoutX(940);
	    		    		        p1Backs.setLayoutX(940);
	    	        			}
	    	        			
	    	        			if(p1hand.getChildren().size() == 3){
	    		        			p1hand.setLayoutX(850);
	    		    		        p1Backs.setLayoutX(850);
	    	        			}
	    	        			if(p1hand.getChildren().size() == 4){
	    		        			p1hand.setLayoutX(760);
	    		    		        p1Backs.setLayoutX(760);
	    	        			}
	    	        			if(p1hand.getChildren().size() == 5){
	    		        			p1hand.setLayoutX(670);
	    		    		        p1Backs.setLayoutX(670);
	    	        			}
	    	        			if(p1hand.getChildren().size() == 6){
	    		        			p1hand.setLayoutX(580);
	    		    		        p1Backs.setLayoutX(580);
	    	        			}
	    	        			if(p1hand.getChildren().size() == 7){
	    		        			p1hand.setLayoutX(490);
	    		    		        p1Backs.setLayoutX(490);
	    	        			}
	    	        			if(p1hand.getChildren().size() == 8){
	    		        			p1hand.setLayoutX(400);
	    		    		        p1Backs.setLayoutX(405);	
	    	        			}
	    	        			
	    	        			if(p1hand.getChildren().size() == 9){
	    	        				p1hand.setLayoutX(330);
	    	        				p1Backs.setLayoutX(400);
	    	        			}
	    	        			if(p1hand.getChildren().size() == 10){
	    	        				p1hand.setLayoutX(250);
	    	        				p1Backs.setLayoutX(280);
	    	        				p1hand.setSpacing(-20);
	    	        				p1Backs.setSpacing(0);
	    	        			}
	            				
	            			}
	            			
		        			
		        			//for player2
		        			if(p2hand.isVisible()){
		        				
		        				if(p2hand.getChildren().size() == 1){
				        			p2hand.setLayoutX(1030);
				    		        p2Backs.setLayoutX(1030);
			        			}
			            		if(p2hand.getChildren().size() == 2){
				        			p2hand.setLayoutX(940);
				    		        p2Backs.setLayoutX(940);
			        			}
			        			
			        			if(p2hand.getChildren().size() == 3){
				        			p2hand.setLayoutX(850);
				    		        p2Backs.setLayoutX(850);
			        			}
			        			if(p2hand.getChildren().size() == 4){
				        			p2hand.setLayoutX(760);
				    		        p2Backs.setLayoutX(760);
			        			}
			        			if(p2hand.getChildren().size() == 5){
				        			p2hand.setLayoutX(670);
				    		        p2Backs.setLayoutX(670);
			        			}
			        			if(p2hand.getChildren().size() == 6){
				        			p2hand.setLayoutX(580);
				    		        p2Backs.setLayoutX(580);
			        			}
			        			if(p2hand.getChildren().size() == 7){
				        			p2hand.setLayoutX(490);
				    		        p2Backs.setLayoutX(490);
			        			}
			        			if(p2hand.getChildren().size() == 8){
				        			p2hand.setLayoutX(400);
				    		        p2Backs.setLayoutX(405);	
			        			}
			        			
			        			if(p2hand.getChildren().size() == 9){
			        				p2hand.setLayoutX(330);
			        				p2Backs.setLayoutX(400);
			        			}
			        			if(p2hand.getChildren().size() == 10){
			        				p2hand.setLayoutX(250);
			        				p2Backs.setLayoutX(280);
			        				p2hand.setSpacing(-20);
			        				p2Backs.setSpacing(0);
			        			}
		        				
		        			}
							
						} catch (Exception e1) {
							SpellCast.stop();
							if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player1 )
								ManaClip1.play();
							if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player2 )
								ManaClip2.play();
							AlertBox.display("Error", e1.getMessage());
							if(SFX)
							AttackOff.play();
							attacking = false;
						}
						
						Hero1.setOnMouseClicked(x->{
			                x.consume();
			            });
			            Hero2.setOnMouseClicked(y->{
			                y.consume();
			            });
						
						Hero1.setEffect(null);
						Hero2.setEffect(null);
						p1hand.setEffect(null);
						p2hand.setEffect(null);
						p1field.setEffect(null);
						p2field.setEffect(null);
						Hero1p.setEffect(null);
						Hero2p.setEffect(null);
						pic.setEffect(null);
						End.setEffect(null);
						p1hand.setDisable(false);
						p2hand.setDisable(false);
						Hero1p.setDisable(false);
						Hero2p.setDisable(false);
	    					
	    				SelectYourTargetImageView.setVisible(false);
	    				CancelAttackImageView.setVisible(false);
	        			attacking = false;
	        			attacker = null;
						
						verifyHeroHP();
						verifyMana();
						verifyHand();
						return;
					   });
			   }
			
			if(power == true && JainaPower1){
				if(c instanceof Spell)
					e.consume();
				else try {			
					if(((Minion) c).isDivine())
			   			window.getChildren().remove(BigDivinity);
					((Mage)player1).useHeroPower((Minion)c);
					if(SFX)
					AttackDone.play();
					power=false;
					
				} catch (Exception e1) {
					AttackDone.stop();
					if(e1 instanceof HeroPowerAlreadyUsedException && SFX )
						PowerClip1.play();
					if(e1 instanceof NotEnoughManaException && SFX )
						ManaClip1.play();
					AlertBox.display("Error", e1.getMessage());
					if(SFX)
					AttackOff.play();
				}
				
				Hero1.setOnMouseClicked(x->{
	                x.consume();
	            });
	            Hero2.setOnMouseClicked(y->{
	                y.consume();
	            });
				
				Hero1.setEffect(null);
				Hero2.setEffect(null);
				p1hand.setEffect(null);
				p2hand.setEffect(null);
				p1field.setEffect(null);
				p2field.setEffect(null);
				Hero1p.setEffect(null);
				Hero2p.setEffect(null);
				pic.setEffect(null);
				if(attacking)
					End.setEffect(null);
				p1hand.setDisable(false);
				p2hand.setDisable(false);
					
				SelectYourTargetImageView.setVisible(false);
				CancelAttackImageView.setVisible(false);
    			attacker = null;
    			JainaPower1=false;
				power=false;
				attacking=false;
				verifyField();
				verifyMana();
				return;
			}
			else if(power == true && JainaPower2){
				if(c instanceof Spell)
					e.consume();
				else try {
					if(((Minion) c).isDivine())
			   			window.getChildren().remove(BigDivinity);
					((Mage)player2).useHeroPower((Minion)c);
					if(SFX)
					AttackDone.play();
					power=false;
					
				} catch (Exception e1) {
					AttackDone.stop();
					if(e1 instanceof HeroPowerAlreadyUsedException && SFX )
						PowerClip2.play();
					if(e1 instanceof NotEnoughManaException && SFX )
						ManaClip2.play();
					AlertBox.display("Error", e1.getMessage());
					if(SFX)
					AttackOff.play();
				}
				
				Hero1.setOnMouseClicked(x->{
	                x.consume();
	            });
	            Hero2.setOnMouseClicked(y->{
	                y.consume();
	            });
				
				Hero1.setEffect(null);
				Hero2.setEffect(null);
				p1hand.setEffect(null);
				p2hand.setEffect(null);
				p1field.setEffect(null);
				p2field.setEffect(null);
				Hero1p.setEffect(null);
				Hero2p.setEffect(null);
				pic.setEffect(null);
				if(attacking)
					End.setEffect(null);
				p1hand.setDisable(false);
				p2hand.setDisable(false);
					
				SelectYourTargetImageView.setVisible(false);
				CancelAttackImageView.setVisible(false);
    			attacker = null;
				JainaPower2=false;
				power=false;
				attacking=false;
				verifyField();
				verifyMana();
				return;
			}
			else if(power==true && AnduinPower1){
				if(c instanceof Spell)
					e.consume();
				else try {
					((Priest)player1).useHeroPower((Minion)c);
					if(SFX)
					AttackDone.play();
					power=false;
				} catch (Exception e1) {
					AttackDone.stop();
					if(e1 instanceof HeroPowerAlreadyUsedException && SFX )
						PowerClip1.play();
					if(e1 instanceof NotEnoughManaException && SFX )
						ManaClip1.play();
					AlertBox.display("Error", e1.getMessage());
					if(SFX)
					AttackOff.play();
				}
				
				Hero1.setOnMouseClicked(x->{
	                x.consume();
	            });
	            Hero2.setOnMouseClicked(y->{
	                y.consume();
	            });
				
				Hero1.setEffect(null);
				Hero2.setEffect(null);
				p1hand.setEffect(null);
				p2hand.setEffect(null);
				p1field.setEffect(null);
				p2field.setEffect(null);
				Hero1p.setEffect(null);
				Hero2p.setEffect(null);
				pic.setEffect(null);
				if(attacking)
					End.setEffect(null);
				p1hand.setDisable(false);
				p2hand.setDisable(false);
					
				SelectYourTargetImageView.setVisible(false);
				CancelAttackImageView.setVisible(false);
    			attacker = null;
				AnduinPower1=false;
				power=false;
				attacking=false;
				verifyField();
				verifyMana();
				return;
			}
			else if(power==true && AnduinPower2){
				if(c instanceof Spell)
					e.consume();
				else try {
					((Priest)player2).useHeroPower((Minion)c);
					if(SFX)
					AttackDone.play();
					power=false;
				} catch (Exception e1) {
					AttackDone.stop();
					if(e1 instanceof HeroPowerAlreadyUsedException && SFX)
						PowerClip2.play();
					if(e1 instanceof NotEnoughManaException && SFX )
						ManaClip2.play();
					AlertBox.display("Error", e1.getMessage());
					if(SFX)
					AttackOff.play();
				}
				
				Hero1.setOnMouseClicked(x->{
	                x.consume();
	            });
	            Hero2.setOnMouseClicked(y->{
	                y.consume();
	            });
				
				Hero1.setEffect(null);
				Hero2.setEffect(null);
				p1hand.setEffect(null);
				p2hand.setEffect(null);
				p1field.setEffect(null);
				p2field.setEffect(null);
				Hero1p.setEffect(null);
				Hero2p.setEffect(null);
				pic.setEffect(null);
				if(attacking)
					End.setEffect(null);
				p1hand.setDisable(false);
				p2hand.setDisable(false);
					
				SelectYourTargetImageView.setVisible(false);
				CancelAttackImageView.setVisible(false);
    			attacker = null;
				AnduinPower2=false;
				power=false;
				attacking=false;
				verifyField();
				verifyMana();
				return;
			}
		else if(attacking==false || power){
			
				attacking=true;
				attacker = c;
				pic.setEffect(colorAdjust);
				card.setEffect(null);
				p1hand.setDisable(true);
				p2hand.setDisable(true);
				Hero1p.setDisable(true);
				Hero2p.setDisable(true);
				p1Backs.setDisable(true);
				p2Backs.setDisable(true);
				
				SelectYourTargetImageView.setVisible(true);
				CancelAttackImageView.setVisible(true);
				
				if(c instanceof Minion){
					
					Hero1.setEffect(glowAndShadow);;
					Hero2.setEffect(glowAndShadow);
					if(game.getCurrentHero() == player2)
						p1field.setEffect(glowAndShadow);
					if(game.getCurrentHero() == player1)
						p2field.setEffect(glowAndShadow);
					p1hand.setEffect(colorAdjust);
					p2hand.setEffect(colorAdjust);
					card.setEffect(glowAndShadow);
					Hero1p.setEffect(colorAdjust);
					Hero2p.setEffect(colorAdjust);
					
					End.setEffect(colorAdjust);
				}
				
				if(c instanceof HeroTargetSpell){
					
					Hero1.setEffect(glowAndShadow);
					Hero2.setEffect(glowAndShadow);
					p1field.setEffect(glowAndShadow);
					p2field.setEffect(glowAndShadow);
					p1hand.setEffect(colorAdjust);
					p2hand.setEffect(colorAdjust);
					Hero1p.setEffect(colorAdjust);
					Hero2p.setEffect(colorAdjust);
					End.setEffect(colorAdjust);
							
				}
				
				if(attacker instanceof LeechingSpell){
					
					p1field.setEffect(glowAndShadow);
					p2field.setEffect(glowAndShadow);
					Hero1.setEffect(colorAdjust);
					Hero2.setEffect(colorAdjust);
					p1hand.setEffect(colorAdjust);
					p2hand.setEffect(colorAdjust);
					Hero1p.setEffect(colorAdjust);
					Hero2p.setEffect(colorAdjust);
					End.setEffect(colorAdjust);
				}
				
				if(attacker instanceof MinionTargetSpell){
					
					p1field.setEffect(glowAndShadow);
					p2field.setEffect(glowAndShadow);
					Hero1.setEffect(colorAdjust);
					Hero2.setEffect(colorAdjust);
					p1hand.setEffect(colorAdjust);
					p2hand.setEffect(colorAdjust);
					Hero1p.setEffect(colorAdjust);
					Hero2p.setEffect(colorAdjust);
					End.setEffect(colorAdjust);
					
				}
				
				if(power && game.getCurrentHero() instanceof Priest || power && game.getCurrentHero() instanceof Mage){
					
					Hero1.setEffect(glowAndShadow);
					Hero2.setEffect(glowAndShadow);
					p1field.setEffect(glowAndShadow);
					p2field.setEffect(glowAndShadow);
					p1hand.setEffect(colorAdjust);
					p2hand.setEffect(colorAdjust);
					End.setEffect(colorAdjust);
					SelectYourTargetImageView.setVisible(true);
					CancelAttackImageView.setVisible(true);
				}
				
				return;
				}
		else if(attacking == true){

		   	if(attacker instanceof Minion && c instanceof Minion){
		   		try {
		   			if(((Minion) c).isDivine())
			   			window.getChildren().remove(BigDivinity);
					game.getCurrentHero().attackWithMinion((Minion) attacker,(Minion) c);
					if(SFX){
					AttackDone.play();
					PlayAttack(attacker.getName());
					}
					attacking=false;
				} catch (Exception e1) {
					AttackDone.stop();
					if(e1.getMessage().contains("Minion is Sleeping")&& SFX  && game.getCurrentHero()==player1)
						SleepingClip1.play();
					if(e1.getMessage().contains("Minion is Sleeping")&& SFX  && game.getCurrentHero()==player2)
						SleepingClip2.play();
					if(e1.getMessage().contains("Minion attacked once this turn")&& SFX  && game.getCurrentHero()==player1)
						AttackedClip1.play();
					if(e1.getMessage().contains("Minion attacked once this turn")&& SFX  && game.getCurrentHero()==player2)
						AttackedClip2.play();
					if((e1 instanceof InvalidTargetException || e1 instanceof NotSummonedException)&&  game.getCurrentHero()==player1 && SFX )
						InvalidClip1.play();
					if((e1 instanceof InvalidTargetException || e1 instanceof NotSummonedException)&&  game.getCurrentHero()==player2 && SFX )
						InvalidClip2.play();
					if(e1 instanceof TauntBypassException&& SFX  && game.getCurrentHero()==player1)
						TauntClip1.play();
					if(e1 instanceof TauntBypassException&& SFX  && game.getCurrentHero()==player2)
						TauntClip2.play();
					AlertBox.display("Error", e1.getMessage());
					if(SFX)
					AttackOff.play();
					attacking = false;
				}
		   		
		   		
		   		
		   		Hero1.setOnMouseClicked(x->{
	                x.consume();
	            });
	            Hero2.setOnMouseClicked(y->{
	                y.consume();
	            });
		   		
		   		Hero1.setEffect(null);
				Hero2.setEffect(null);
				p1hand.setEffect(null);
				p2hand.setEffect(null);
				p1field.setEffect(null);
				p2field.setEffect(null);
				Hero1p.setEffect(null);
				Hero2p.setEffect(null);
				pic.setEffect(null);
				End.setEffect(null);
				Hero1p.setDisable(false);
				Hero2p.setDisable(false);
				p1hand.setDisable(false);
				p2hand.setDisable(false);
				p1Backs.setDisable(false);
				p2Backs.setDisable(false);
				
	    		SelectYourTargetImageView.setVisible(false);
	    		CancelAttackImageView.setVisible(false);
				verifyHeroHP();	
				attacker = null;
		   		attacking=false;
		   		verifyField();
		   		return;
		   		
		   	}
		   	else if(attacker instanceof LeechingSpell && c instanceof Minion){
		   			try {	
		   				if(((Minion) c).isDivine())
				   			window.getChildren().remove(BigDivinity);
						game.getCurrentHero().castSpell((LeechingSpell)attacker, (Minion) c);
						if(SFX)
						SpellCast.play();
						if(p1hand.isVisible()){
            				
            				if(p1hand.getChildren().size() == 1){
    		        			p1hand.setLayoutX(1030);
    		    		        p1Backs.setLayoutX(1030);
    	        			}
    	            		if(p1hand.getChildren().size() == 2){
    		        			p1hand.setLayoutX(940);
    		    		        p1Backs.setLayoutX(940);
    	        			}
    	        			
    	        			if(p1hand.getChildren().size() == 3){
    		        			p1hand.setLayoutX(850);
    		    		        p1Backs.setLayoutX(850);
    	        			}
    	        			if(p1hand.getChildren().size() == 4){
    		        			p1hand.setLayoutX(760);
    		    		        p1Backs.setLayoutX(760);
    	        			}
    	        			if(p1hand.getChildren().size() == 5){
    		        			p1hand.setLayoutX(670);
    		    		        p1Backs.setLayoutX(670);
    	        			}
    	        			if(p1hand.getChildren().size() == 6){
    		        			p1hand.setLayoutX(580);
    		    		        p1Backs.setLayoutX(580);
    	        			}
    	        			if(p1hand.getChildren().size() == 7){
    		        			p1hand.setLayoutX(490);
    		    		        p1Backs.setLayoutX(490);
    	        			}
    	        			if(p1hand.getChildren().size() == 8){
    		        			p1hand.setLayoutX(400);
    		    		        p1Backs.setLayoutX(405);	
    	        			}
    	        			
    	        			if(p1hand.getChildren().size() == 9){
    	        				p1hand.setLayoutX(330);
    	        				p1Backs.setLayoutX(400);
    	        			}
    	        			if(p1hand.getChildren().size() == 10){
    	        				p1hand.setLayoutX(250);
    	        				p1Backs.setLayoutX(280);
    	        				p1hand.setSpacing(-20);
    	        				p1Backs.setSpacing(0);
    	        			}
            				
            			}
            			
	        			
	        			//for player2
	        			if(p2hand.isVisible()){
	        				
	        				if(p2hand.getChildren().size() == 1){
			        			p2hand.setLayoutX(1030);
			    		        p2Backs.setLayoutX(1030);
		        			}
		            		if(p2hand.getChildren().size() == 2){
			        			p2hand.setLayoutX(940);
			    		        p2Backs.setLayoutX(940);
		        			}
		        			
		        			if(p2hand.getChildren().size() == 3){
			        			p2hand.setLayoutX(850);
			    		        p2Backs.setLayoutX(850);
		        			}
		        			if(p2hand.getChildren().size() == 4){
			        			p2hand.setLayoutX(760);
			    		        p2Backs.setLayoutX(760);
		        			}
		        			if(p2hand.getChildren().size() == 5){
			        			p2hand.setLayoutX(670);
			    		        p2Backs.setLayoutX(670);
		        			}
		        			if(p2hand.getChildren().size() == 6){
			        			p2hand.setLayoutX(580);
			    		        p2Backs.setLayoutX(580);
		        			}
		        			if(p2hand.getChildren().size() == 7){
			        			p2hand.setLayoutX(490);
			    		        p2Backs.setLayoutX(490);
		        			}
		        			if(p2hand.getChildren().size() == 8){
			        			p2hand.setLayoutX(400);
			    		        p2Backs.setLayoutX(405);	
		        			}
		        			
		        			if(p2hand.getChildren().size() == 9){
		        				p2hand.setLayoutX(330);
		        				p2Backs.setLayoutX(400);
		        			}
		        			if(p2hand.getChildren().size() == 10){
		        				p2hand.setLayoutX(250);
		        				p2Backs.setLayoutX(280);
		        				p2hand.setSpacing(-20);
		        				p2Backs.setSpacing(0);
		        			}
	        				
	        			}
						
					} catch (Exception e1) {
						SpellCast.stop();
						if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player1 )
							ManaClip1.play();
						if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player2 )
							ManaClip2.play();
						AlertBox.display("Error", e1.getMessage());
						if(SFX)
						AttackOff.play();
						attacking=false;
						
					}
		   			
		   			Hero1.setOnMouseClicked(x->{
		                x.consume();
		            });
		            Hero2.setOnMouseClicked(y->{
		                y.consume();
		            });
		   			
		   			Hero1.setEffect(null);
					Hero2.setEffect(null);
					p1hand.setEffect(null);
					p2hand.setEffect(null);
					p1field.setEffect(null);
					p2field.setEffect(null);
					Hero1p.setEffect(null);
					Hero2p.setEffect(null);
					pic.setEffect(null);
					End.setEffect(null);
					Hero1p.setDisable(false);
					Hero2p.setDisable(false);
					p1hand.setDisable(false);
					p2hand.setDisable(false);
					p1Backs.setDisable(false);
					p2Backs.setDisable(false);
					
		    		SelectYourTargetImageView.setVisible(false);
		    		CancelAttackImageView.setVisible(false);
					verifyHeroHP();	
					attacker = null;
			   		attacking=false;
			   		verifyField();
		   			
	   				verifyHand();
	   				verifyMana();
	   				return;
		   	}
		   	else if(attacker instanceof MinionTargetSpell && c instanceof Minion){
	   			try {
	   				if(((Minion) c).isDivine())
			   			window.getChildren().remove(BigDivinity);
	   				if(attacker.getName().equals("Shadow Word: Death")&& ((Minion)c).getAttack()<5){
	   					AlertBox.display("Error", "This card can be played on a minion with 5+ attack pts");
	   					if(SFX)
	   					AttackOff.play();
	   					attacking=false;

			   			Hero1.setEffect(null);
						Hero2.setEffect(null);
						p1hand.setEffect(null);
						p2hand.setEffect(null);
						p1field.setEffect(null);
						p2field.setEffect(null);
						Hero1p.setEffect(null);
						Hero2p.setEffect(null);
						pic.setEffect(null);
						End.setEffect(null);
						Hero1p.setDisable(false);
						Hero2p.setDisable(false);
						p1hand.setDisable(false);
						p2hand.setDisable(false);
						p1Backs.setDisable(false);
						p2Backs.setDisable(false);
						
			    		SelectYourTargetImageView.setVisible(false);
			    		CancelAttackImageView.setVisible(false);
			   			
			   			attacking = false;

			   			verifyField();
			   			verifyHand();
			   			verifyMana();
			   			return;
	   				}
	   				else {game.getCurrentHero().castSpell((MinionTargetSpell)attacker, (Minion) c);
	   					 if(SFX)
	   				     SpellCast.play();
	   				}
					if(p1hand.isVisible()){
        				
        				if(p1hand.getChildren().size() == 1){
		        			p1hand.setLayoutX(1030);
		    		        p1Backs.setLayoutX(1030);
	        			}
	            		if(p1hand.getChildren().size() == 2){
		        			p1hand.setLayoutX(940);
		    		        p1Backs.setLayoutX(940);
	        			}
	        			
	        			if(p1hand.getChildren().size() == 3){
		        			p1hand.setLayoutX(850);
		    		        p1Backs.setLayoutX(850);
	        			}
	        			if(p1hand.getChildren().size() == 4){
		        			p1hand.setLayoutX(760);
		    		        p1Backs.setLayoutX(760);
	        			}
	        			if(p1hand.getChildren().size() == 5){
		        			p1hand.setLayoutX(670);
		    		        p1Backs.setLayoutX(670);
	        			}
	        			if(p1hand.getChildren().size() == 6){
		        			p1hand.setLayoutX(580);
		    		        p1Backs.setLayoutX(580);
	        			}
	        			if(p1hand.getChildren().size() == 7){
		        			p1hand.setLayoutX(490);
		    		        p1Backs.setLayoutX(490);
	        			}
	        			if(p1hand.getChildren().size() == 8){
		        			p1hand.setLayoutX(400);
		    		        p1Backs.setLayoutX(405);	
	        			}
	        			
	        			if(p1hand.getChildren().size() == 9){
	        				p1hand.setLayoutX(330);
	        				p1Backs.setLayoutX(400);
	        			}
	        			if(p1hand.getChildren().size() == 10){
	        				p1hand.setLayoutX(250);
	        				p1Backs.setLayoutX(280);
	        				p1hand.setSpacing(-20);
	        				p1Backs.setSpacing(0);
	        			}
        				
        			}
        			
        			
        			//for player2
        			if(p2hand.isVisible()){
        				
        				if(p2hand.getChildren().size() == 1){
		        			p2hand.setLayoutX(1030);
		    		        p2Backs.setLayoutX(1030);
	        			}
	            		if(p2hand.getChildren().size() == 2){
		        			p2hand.setLayoutX(940);
		    		        p2Backs.setLayoutX(940);
	        			}
	        			
	        			if(p2hand.getChildren().size() == 3){
		        			p2hand.setLayoutX(850);
		    		        p2Backs.setLayoutX(850);
	        			}
	        			if(p2hand.getChildren().size() == 4){
		        			p2hand.setLayoutX(760);
		    		        p2Backs.setLayoutX(760);
	        			}
	        			if(p2hand.getChildren().size() == 5){
		        			p2hand.setLayoutX(670);
		    		        p2Backs.setLayoutX(670);
	        			}
	        			if(p2hand.getChildren().size() == 6){
		        			p2hand.setLayoutX(580);
		    		        p2Backs.setLayoutX(580);
	        			}
	        			if(p2hand.getChildren().size() == 7){
		        			p2hand.setLayoutX(490);
		    		        p2Backs.setLayoutX(490);
	        			}
	        			if(p2hand.getChildren().size() == 8){
		        			p2hand.setLayoutX(400);
		    		        p2Backs.setLayoutX(405);	
	        			}
	        			
	        			if(p2hand.getChildren().size() == 9){
	        				p2hand.setLayoutX(330);
	        				p2Backs.setLayoutX(400);
	        			}
	        			if(p2hand.getChildren().size() == 10){
	        				p2hand.setLayoutX(250);
	        				p2Backs.setLayoutX(280);
	        				p2hand.setSpacing(-20);
	        				p2Backs.setSpacing(0);
	        			}
        				
        			}
					
					
				} catch (Exception e1) {
					SpellCast.stop();
					if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player1 )
						ManaClip1.play();
					if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player2 )
						ManaClip2.play();
					if((e1 instanceof InvalidTargetException || e1 instanceof NotSummonedException) &&  SFX && game.getCurrentHero()==player1 )
						InvalidClip1.play();
					if((e1 instanceof InvalidTargetException || e1 instanceof NotSummonedException) &&  SFX && game.getCurrentHero()==player2 )
						InvalidClip2.play();
					AlertBox.display("Error", e1.getMessage());
					if(SFX)
					AttackOff.play();
					attacking=false;

		   			Hero1.setEffect(null);
					Hero2.setEffect(null);
					p1hand.setEffect(null);
					p2hand.setEffect(null);
					p1field.setEffect(null);
					p2field.setEffect(null);
					Hero1p.setEffect(null);
					Hero2p.setEffect(null);
					pic.setEffect(null);
					End.setEffect(null);
					Hero1p.setDisable(false);
					Hero2p.setDisable(false);
					p1hand.setDisable(false);
					p2hand.setDisable(false);
					p1Backs.setDisable(false);
					p2Backs.setDisable(false);
					
		    		SelectYourTargetImageView.setVisible(false);
		    		CancelAttackImageView.setVisible(false);
		   			
		   			attacking = false;

		   			verifyField();
		   			verifyHand();
		   			verifyMana();
		   			return;
					
				}
	   			
	   			Hero1.setEffect(null);
				Hero2.setEffect(null);
				p1hand.setEffect(null);
				p2hand.setEffect(null);
				p1field.setEffect(null);
				p2field.setEffect(null);
				Hero1p.setEffect(null);
				Hero2p.setEffect(null);
				pic.setEffect(null);
				End.setEffect(null);
				Hero1p.setDisable(false);
				Hero2p.setDisable(false);
				p1hand.setDisable(false);
				p2hand.setDisable(false);
				p1Backs.setDisable(false);
				p2Backs.setDisable(false);
				
	    		SelectYourTargetImageView.setVisible(false);
	    		CancelAttackImageView.setVisible(false);
	   			
	   			attacking = false;
	   			attacker = null;
	   			verifyField();
	   			verifyHand();
	   			verifyMana();
	   			return;
	   	}
		   		
		   	}
		});
		attacking = false;
		return;
	}

	void verifyHeroHP(){
		HeroHealth1.setText(heroHP(player1).getText());
		HeroHealth2.setText(heroHP(player2).getText());
		if(Integer.parseInt(HeroHealth1.getText())<10){
			HeroHealth1.setLayoutX(183);
	        HeroHealth1.setLayoutY(982);
		}
		else{
			HeroHealth1.setLayoutX(177);
	        HeroHealth1.setLayoutY(982);
		}
			
		 if(Integer.parseInt(HeroHealth2.getText())<10){
 			HeroHealth2.setLayoutX(1882);
 			HeroHealth2.setLayoutY(195);   
 			}
		 else{
	        HeroHealth2.setLayoutX(1876);
	        HeroHealth2.setLayoutY(195);  
		        }
		String P1Name;
		String P2Name;
		if(Player1Name.getText().equals(""))
			 P1Name = "Player1";
		else
			P1Name = Player1Name.getText();
		if(Player2Name.getText().equals(""))
			 P2Name = "Player2";
		else
			P2Name = Player2Name.getText();
		
		if(Integer.parseInt(HeroHealth1.getText())<=10){
			DuelMusic.stop();
			if(SFX && !threaten1){
				ThreatenClip1.play();
				threaten1=true;
			}
			if(Music && !overtime)
				OverTimeMusic.play();
			if(OT2 && !OT1){
				AlertBox.display("BE CAREFUL", "Rough battle there!"
								+"\n"+P1Name+" just dropped to 10 HP as well!" );
			overtime=true;
			OT1=true;
			}
			if(!OT1){
			AlertBox.display("BE CAREFUL", "Things are getting intense!"
					        +"\n"+P1Name+" just dropped to 10 HP!" );
			overtime=true;
			OT1=true;
			}
			
		}
		if(Integer.parseInt(HeroHealth2.getText())<=10){
			DuelMusic.stop();
			if(SFX  && !threaten2){
				ThreatenClip2.play();
				threaten2=true;
			}
			if(Music && !overtime)
				OverTimeMusic.play();
			if(OT1 && !OT2){
			AlertBox.display("BE CAREFUL", "Rough battle there!"
							+"\n"+P2Name+" just dropped to 10 HP as well!" );
			overtime=true;
			OT2=true;
			}
			if(!OT2){
			AlertBox.display("BE CAREFUL", "Things are getting intense!"
					        +"\n"+P2Name+" just dropped to 10 HP!" );
			overtime=true;
			OT2=true;
			}
		}
	}
	

	void setHandClickable(Card c, AnchorPane card,Hero player,HBox field,HBox hand){
		
		Image BigImage = null;
		if(!c.getName().equals("Shadow Word: Death"))
			BigImage = new Image(getClass().getResourceAsStream(c.getName()+".png"));
		else  BigImage = new Image(getClass().getResourceAsStream("Shadow Word Death.png"));
		    ImageView BigImageView = new ImageView(BigImage);
		
		
		BigImageView.setX(1);
		BigImageView.setY(360);
		BigImageView.setFitHeight(470);
		BigImageView.setFitWidth(278);
		BigImageView.setPreserveRatio(true);
		
		
		Image divine = new Image(getClass().getResourceAsStream("shield.png"));
		ImageView BigDivinity = new ImageView(divine);
		BigDivinity.setX(35);
		BigDivinity.setY(353);
		BigDivinity.setFitHeight(430);
		BigDivinity.setFitWidth(220);
		
		
		BigDivinity.setPreserveRatio(true);
	    
		Label BigMana = new Label(""+c.getManaCost());
		BigMana.setTextFill(Color.WHITE);
		BigMana.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
		BigMana.setLayoutX(36);
		BigMana.setLayoutY(377);
		Label BigAttack = new Label();
		Label BigHP = new Label();
		
		BigAttack.setTextFill(Color.WHITE);
		BigAttack.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
		BigAttack.setLayoutX(36);
		BigAttack.setLayoutY(675);
		BigHP.setTextFill(Color.WHITE);
	    BigHP.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
	    BigHP.setLayoutX(235);
	    BigHP.setLayoutY(678);
	    
        if(c instanceof Minion && c.getRarity().equals(Rarity.LEGENDARY)&&c.getManaCost()>=10){
        	BigMana.setLayoutX(26);
    		BigMana.setLayoutY(398);
        }
        else if(c instanceof Minion && c.getRarity().equals(Rarity.LEGENDARY)&&c.getManaCost()<10){
        	BigMana.setLayoutX(36);
    		BigMana.setLayoutY(394);
        }
        else if(c instanceof Spell && c.getManaCost()>=10){
        	BigMana.setLayoutX(26);
    		BigMana.setLayoutY(398);
        }

        
        
		card.setOnMouseEntered(a->{
			
			card.setEffect(glowAndShadow);
			
			window.getChildren().addAll(BigImageView ,BigMana);	
		
			if(c instanceof Minion){
				
				BigAttack.setText(""+(((Minion) c).getAttack()));
				BigHP.setText(""+((Minion) c).getCurrentHP());
				
				 if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getCurrentHP()>=10){
			        	BigHP.setLayoutX(221);
			        	BigHP.setLayoutY(698);
			       }
			       else if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getCurrentHP()<10){
			    	   BigHP.setLayoutX(235);
			    	   BigHP.setLayoutY(695);
			           }
			        
			        
			        if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getAttack()>=10){
			        	BigAttack.setLayoutX(28);
			        	BigAttack.setLayoutY(695);
			   }
			   	else if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getAttack()<10){
			   			BigAttack.setLayoutX(35);
			   			BigAttack.setLayoutY(695);
			        }

			   	if(((Minion) c).isDivine()){
			   		BigDivinity.setY(350);
			    }

				window.getChildren().addAll(BigAttack, BigHP);
				
				if((((Minion)c).isDivine())){
					window.getChildren().add(BigDivinity);
				}
			}

				
			timeline = new Timeline();
			kv = new KeyValue(card.translateYProperty(),-28,Interpolator.EASE_IN);
			kf = new KeyFrame(Duration.seconds(0.1), kv);
			timeline.getKeyFrames().add(kf);
			timeline.play();
				
				
			
		});
		
		card.setOnMouseExited(a -> {
			
			timeline2 = new Timeline();
			kv2 = new KeyValue(card.translateYProperty(),0,Interpolator.EASE_IN);
			kf2 = new KeyFrame(Duration.seconds(0.1), kv2);
			timeline2.getKeyFrames().add(kf2);
			timeline2.play();
			
			card.setEffect(null);
			
			window.getChildren().removeAll(BigImageView, BigMana);
			if(c instanceof Minion){
				window.getChildren().removeAll(BigAttack, BigHP);
				
				if((((Minion)c).isDivine())){
					window.getChildren().remove(BigDivinity);
				}
			}	
		});
	
		if(c instanceof Minion){
            card.setOnMouseClicked(e->{
            	
            	if(e.getClickCount()==2){
            		try {            			
            			player.playMinion((Minion)c);
            			if(SFX){
            			Summon.play();
            			PlaySummon(c.getName());
            			}
            			if(p1hand.isVisible()){
            				
            				if(p1hand.getChildren().size() == 1){
    		        			p1hand.setLayoutX(1030);
    		    		        p1Backs.setLayoutX(1030);
    	        			}
    	            		if(p1hand.getChildren().size() == 2){
    		        			p1hand.setLayoutX(940);
    		    		        p1Backs.setLayoutX(940);
    	        			}
    	        			
    	        			if(p1hand.getChildren().size() == 3){
    		        			p1hand.setLayoutX(850);
    		    		        p1Backs.setLayoutX(850);
    	        			}
    	        			if(p1hand.getChildren().size() == 4){
    		        			p1hand.setLayoutX(760);
    		    		        p1Backs.setLayoutX(760);
    	        			}
    	        			if(p1hand.getChildren().size() == 5){
    		        			p1hand.setLayoutX(670);
    		    		        p1Backs.setLayoutX(670);
    	        			}
    	        			if(p1hand.getChildren().size() == 6){
    		        			p1hand.setLayoutX(580);
    		    		        p1Backs.setLayoutX(580);
    	        			}
    	        			if(p1hand.getChildren().size() == 7){
    		        			p1hand.setLayoutX(490);
    		    		        p1Backs.setLayoutX(490);
    	        			}
    	        			if(p1hand.getChildren().size() == 8){
    		        			p1hand.setLayoutX(400);
    		    		        p1Backs.setLayoutX(405);	
    	        			}
    	        			
    	        			if(p1hand.getChildren().size() == 9){
    	        				p1hand.setLayoutX(330);
    	        				p1Backs.setLayoutX(400);
    	        			}
    	        			if(p1hand.getChildren().size() == 10){
    	        				p1hand.setLayoutX(250);
    	        				p1Backs.setLayoutX(280);
    	        				p1hand.setSpacing(-20);
    	        				p1Backs.setSpacing(0);
    	        			}
            				
            			}
            			
	        			
	        			//for player2
	        			if(p2hand.isVisible()){
	        				
	        				if(p2hand.getChildren().size() == 1){
			        			p2hand.setLayoutX(1030);
			    		        p2Backs.setLayoutX(1030);
		        			}
		            		if(p2hand.getChildren().size() == 2){
			        			p2hand.setLayoutX(940);
			    		        p2Backs.setLayoutX(940);
		        			}
		        			
		        			if(p2hand.getChildren().size() == 3){
			        			p2hand.setLayoutX(850);
			    		        p2Backs.setLayoutX(850);
		        			}
		        			if(p2hand.getChildren().size() == 4){
			        			p2hand.setLayoutX(760);
			    		        p2Backs.setLayoutX(760);
		        			}
		        			if(p2hand.getChildren().size() == 5){
			        			p2hand.setLayoutX(670);
			    		        p2Backs.setLayoutX(670);
		        			}
		        			if(p2hand.getChildren().size() == 6){
			        			p2hand.setLayoutX(580);
			    		        p2Backs.setLayoutX(580);
		        			}
		        			if(p2hand.getChildren().size() == 7){
			        			p2hand.setLayoutX(490);
			    		        p2Backs.setLayoutX(490);
		        			}
		        			if(p2hand.getChildren().size() == 8){
			        			p2hand.setLayoutX(400);
			    		        p2Backs.setLayoutX(405);	
		        			}
		        			
		        			if(p2hand.getChildren().size() == 9){
		        				p2hand.setLayoutX(330);
		        				p2Backs.setLayoutX(400);
		        			}
		        			if(p2hand.getChildren().size() == 10){
		        				p2hand.setLayoutX(250);
		        				p2Backs.setLayoutX(280);
		        				p2hand.setSpacing(-20);
		        				p2Backs.setSpacing(0);
		        			}
	        				
	        			}
	        			
            			
						if(game.getCurrentHero().equals(player1))
							p1Backs.getChildren().remove(0);
						else if(game.getCurrentHero().equals(player2))
							p2Backs.getChildren().remove(0);
						verifyMana();
						field.getChildren().add((AnchorPane)e.getSource());
						verifyField();
						
   				} catch (Exception e1) {
   					if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player1 )
						ManaClip1.play();
					if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player2 )
						ManaClip2.play();
					if(e1 instanceof FullFieldException&& SFX && game.getCurrentHero()==player1 )
						FieldClip1.play();
					if(e1 instanceof FullFieldException && SFX && game.getCurrentHero()==player2 )
						FieldClip2.play();
						AlertBox.display("ERROR",e1.getMessage());								
					} 
            		
       	}      		
            	});
            }
		else if(c instanceof Spell){
			{card.setOnMouseClicked(e->{
           if(c instanceof AOESpell && e.getClickCount()==2){
         		try {
					game.getCurrentHero().castSpell((AOESpell) c, game.getOpponent().getField());
					if(SFX)
					SpellCast.play();
					verifyMana();
			   } catch (Exception e1) {
				   SpellCast.stop();
				   if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player1 )
						ManaClip1.play();
					if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player2 )
						ManaClip2.play();
				AlertBox.display("Error",e1.getMessage());
				if(SFX)
				AttackOff.play();
				}
         		
         		if(p1hand.isVisible()){
    				
    				if(p1hand.getChildren().size() == 1){
	        			p1hand.setLayoutX(1030);
	    		        p1Backs.setLayoutX(1030);
        			}
            		if(p1hand.getChildren().size() == 2){
	        			p1hand.setLayoutX(940);
	    		        p1Backs.setLayoutX(940);
        			}
        			
        			if(p1hand.getChildren().size() == 3){
	        			p1hand.setLayoutX(850);
	    		        p1Backs.setLayoutX(850);
        			}
        			if(p1hand.getChildren().size() == 4){
	        			p1hand.setLayoutX(760);
	    		        p1Backs.setLayoutX(760);
        			}
        			if(p1hand.getChildren().size() == 5){
	        			p1hand.setLayoutX(670);
	    		        p1Backs.setLayoutX(670);
        			}
        			if(p1hand.getChildren().size() == 6){
	        			p1hand.setLayoutX(580);
	    		        p1Backs.setLayoutX(580);
        			}
        			if(p1hand.getChildren().size() == 7){
	        			p1hand.setLayoutX(490);
	    		        p1Backs.setLayoutX(490);
        			}
        			if(p1hand.getChildren().size() == 8){
	        			p1hand.setLayoutX(400);
	    		        p1Backs.setLayoutX(405);	
        			}
        			
        			if(p1hand.getChildren().size() == 9){
        				p1hand.setLayoutX(330);
        				p1Backs.setLayoutX(400);
        			}
        			if(p1hand.getChildren().size() == 10){
        				p1hand.setLayoutX(250);
        				p1Backs.setLayoutX(280);
        				p1hand.setSpacing(-20);
        				p1Backs.setSpacing(0);
        			}
    				
    			}
    			
    			
    			//for player2
    			if(p2hand.isVisible()){
    				
    				if(p2hand.getChildren().size() == 1){
	        			p2hand.setLayoutX(1030);
	    		        p2Backs.setLayoutX(1030);
        			}
            		if(p2hand.getChildren().size() == 2){
	        			p2hand.setLayoutX(940);
	    		        p2Backs.setLayoutX(940);
        			}
        			
        			if(p2hand.getChildren().size() == 3){
	        			p2hand.setLayoutX(850);
	    		        p2Backs.setLayoutX(850);
        			}
        			if(p2hand.getChildren().size() == 4){
	        			p2hand.setLayoutX(760);
	    		        p2Backs.setLayoutX(760);
        			}
        			if(p2hand.getChildren().size() == 5){
	        			p2hand.setLayoutX(670);
	    		        p2Backs.setLayoutX(670);
        			}
        			if(p2hand.getChildren().size() == 6){
	        			p2hand.setLayoutX(580);
	    		        p2Backs.setLayoutX(580);
        			}
        			if(p2hand.getChildren().size() == 7){
	        			p2hand.setLayoutX(490);
	    		        p2Backs.setLayoutX(490);
        			}
        			if(p2hand.getChildren().size() == 8){
	        			p2hand.setLayoutX(400);
	    		        p2Backs.setLayoutX(405);	
        			}
        			
        			if(p2hand.getChildren().size() == 9){
        				p2hand.setLayoutX(330);
        				p2Backs.setLayoutX(400);
        			}
        			if(p2hand.getChildren().size() == 10){
        				p2hand.setLayoutX(250);
        				p2Backs.setLayoutX(280);
        				p2hand.setSpacing(-20);
        				p2Backs.setSpacing(0);
        			}
    				
    			}         		
				verifyField();
				verifyMana();
				verifyHand();
           }
          else if(c instanceof FieldSpell && e.getClickCount()==2){
		try {
			game.getCurrentHero().castSpell((FieldSpell) c);
			if(SFX)
			SpellCast.play();
			verifyMana();
		} catch (Exception e1) {
			SpellCast.stop();
			if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player1 )
				ManaClip1.play();
			if(e1 instanceof NotEnoughManaException && SFX && game.getCurrentHero()==player2 )
				ManaClip2.play();
			AlertBox.display("Error",e1.getMessage());
			if(SFX)
			AttackOff.play();
		}
		
		if(p1hand.isVisible()){
			
			if(p1hand.getChildren().size() == 1){
    			p1hand.setLayoutX(1030);
		        p1Backs.setLayoutX(1030);
			}
    		if(p1hand.getChildren().size() == 2){
    			p1hand.setLayoutX(940);
		        p1Backs.setLayoutX(940);
			}
			
			if(p1hand.getChildren().size() == 3){
    			p1hand.setLayoutX(850);
		        p1Backs.setLayoutX(850);
			}
			if(p1hand.getChildren().size() == 4){
    			p1hand.setLayoutX(760);
		        p1Backs.setLayoutX(760);
			}
			if(p1hand.getChildren().size() == 5){
    			p1hand.setLayoutX(670);
		        p1Backs.setLayoutX(670);
			}
			if(p1hand.getChildren().size() == 6){
    			p1hand.setLayoutX(580);
		        p1Backs.setLayoutX(580);
			}
			if(p1hand.getChildren().size() == 7){
    			p1hand.setLayoutX(490);
		        p1Backs.setLayoutX(490);
			}
			if(p1hand.getChildren().size() == 8){
    			p1hand.setLayoutX(400);
		        p1Backs.setLayoutX(405);	
			}
			
			if(p1hand.getChildren().size() == 9){
				p1hand.setLayoutX(330);
				p1Backs.setLayoutX(400);
			}
			if(p1hand.getChildren().size() == 10){
				p1hand.setLayoutX(250);
				p1Backs.setLayoutX(280);
				p1hand.setSpacing(-20);
				p1Backs.setSpacing(0);
			}
			
		}
		
		
		//for player2
		if(p2hand.isVisible()){
			
			if(p2hand.getChildren().size() == 1){
    			p2hand.setLayoutX(1030);
		        p2Backs.setLayoutX(1030);
			}
    		if(p2hand.getChildren().size() == 2){
    			p2hand.setLayoutX(940);
		        p2Backs.setLayoutX(940);
			}
			
			if(p2hand.getChildren().size() == 3){
    			p2hand.setLayoutX(850);
		        p2Backs.setLayoutX(850);
			}
			if(p2hand.getChildren().size() == 4){
    			p2hand.setLayoutX(760);
		        p2Backs.setLayoutX(760);
			}
			if(p2hand.getChildren().size() == 5){
    			p2hand.setLayoutX(670);
		        p2Backs.setLayoutX(670);
			}
			if(p2hand.getChildren().size() == 6){
    			p2hand.setLayoutX(580);
		        p2Backs.setLayoutX(580);
			}
			if(p2hand.getChildren().size() == 7){
    			p2hand.setLayoutX(490);
		        p2Backs.setLayoutX(490);
			}
			if(p2hand.getChildren().size() == 8){
    			p2hand.setLayoutX(400);
		        p2Backs.setLayoutX(405);	
			}
			
			if(p2hand.getChildren().size() == 9){
				p2hand.setLayoutX(330);
				p2Backs.setLayoutX(400);
			}
			if(p2hand.getChildren().size() == 10){
				p2hand.setLayoutX(250);
				p2Backs.setLayoutX(280);
				p2hand.setSpacing(-20);
				p2Backs.setSpacing(0);
			}
			
		}
		
            verifyField();
			verifyMana();
			verifyHand();	
          }
         });
		}
            }
        }
	
	AnchorPane backcreator(){
		BackCard = new AnchorPane();
        Image BackCardimg = new Image(getClass().getResourceAsStream("BackCard.jpg.png"));
        ImageView BackCardpic= new ImageView(BackCardimg);
        BackCardpic.setFitHeight(330);
	    BackCardpic.setFitWidth(150);
	    BackCardpic.setPreserveRatio(true);
	    BackCard.getChildren().add(BackCardpic);
	    
	    Image BigBack = new Image(getClass().getResourceAsStream("BackCard.jpg.png"));
    	ImageView BigBackView = new ImageView(BigBack);


         BigBackView.setX(37);
         BigBackView.setY(388);
         BigBackView.setFitHeight(328);
         BigBackView.setPreserveRatio(true);

    	
    	
	    BackCardpic.setOnMouseEntered(e ->{
	    	BackCardpic.setEffect(glowAndShadow);
	    	window.getChildren().add(BigBackView);
	    	
	    	timeline3 = new Timeline();
			kv3 = new KeyValue(BackCardpic.translateYProperty(),-28,Interpolator.EASE_IN);
			kf3 = new KeyFrame(Duration.seconds(0.1), kv3);
			timeline3.getKeyFrames().add(kf3);
			timeline3.play();
	    	
	    });
	    BackCardpic.setOnMouseExited(e ->{
	    	BackCardpic.setEffect(null);
	    	window.getChildren().remove(BigBackView);
	    	timeline4 = new Timeline();
			kv4 = new KeyValue(BackCardpic.translateYProperty(),0,Interpolator.EASE_IN);
			kf4 = new KeyFrame(Duration.seconds(0.1), kv4);
			timeline4.getKeyFrames().add(kf4);
			timeline4.play();
	    	
	    });
	    
	    
	    return BackCard;
	}
	
	
	void verifyDecks(){
		P1deck = new Label();
		P2deck = new Label();
		P1deck.setText(player1.getDeck().size()+"");
		P2deck.setText(player2.getDeck().size()+"");
		P1deck.setFont(Font.font("Showcard Gothic", FontWeight.BOLD, 45));
		P1deck.setTextFill(Color.BLACK);
		P2deck.setFont(Font.font("Showcard Gothic", FontWeight.BOLD, 45));
		P2deck.setTextFill(Color.BLACK);
		if(Integer.parseInt(P1deck.getText())==5 && SFX && !deckAlert1 ){
			if(SFX)
			LowCardsClip1.play();
			deckAlert1 = true;
		}
		if(Integer.parseInt(P2deck.getText())==5 && SFX && !deckAlert2 ){
			if(SFX)
			LowCardsClip2.play();
			deckAlert2 = true;
		}
		if(Integer.parseInt(P1deck.getText())==0 && SFX && !outOfCards1 ){
			if(SFX)
			OutOfCardsClip1.play();
			outOfCards1 = true;
		}
		if(Integer.parseInt(P2deck.getText())==0 && SFX && !outOfCards2 ){
			if(SFX)
			OutOfCardsClip2.play();
			outOfCards2 = true;
		}
		if(Integer.parseInt(P1deck.getText())==1){
			P1Deck = new Image(getClass().getResourceAsStream("BackCardRotated.jpg.png"));
			P1DeckView = new ImageView(P1Deck);
			P1DeckView.setFitHeight(139);
			P1DeckView.setFitWidth(205);
		}
		else{
			P1Deck = new Image(getClass().getResourceAsStream("Player1Deck.png"));
			P1DeckView = new ImageView(P1Deck);
		}
		if(Integer.parseInt(P2deck.getText())==1){
			P2Deck = new Image(getClass().getResourceAsStream("BackCardRotated.jpg.png"));
			P2DeckView = new ImageView(P2Deck);
			P2DeckView.setFitHeight(139);
			P2DeckView.setFitWidth(205);
		}
		else{
			P2Deck = new Image(getClass().getResourceAsStream("Player2Deck.png"));
			P2DeckView = new ImageView(P2Deck);
		}
		P1deck.setEffect(borderGlow);
		P2deck.setEffect(borderGlow);
		window.getChildren().addAll(P1DeckView,P2DeckView,P1deck,P2deck);
		if(Integer.parseInt(P1deck.getText())>=10){
		    P1deck.setLayoutX(1740);
			P1deck.setLayoutY(688);
		}
		else{
			P1deck.setLayoutX(1750);
			P1deck.setLayoutY(688);
		}
		if(Integer.parseInt(P2deck.getText())>=10){
			P2deck.setLayoutX(1740);
			P2deck.setLayoutY(375);
		}
		else{
			P2deck.setLayoutX(1750);
			P2deck.setLayoutY(375);
		}
		if(Integer.parseInt(P1deck.getText())==1){
			P1deck.setLayoutX(1757);
			P1deck.setLayoutY(682);
		}
		if(Integer.parseInt(P2deck.getText())==1){
			P2deck.setLayoutX(1757);
			P2deck.setLayoutY(380);
		}
		if(player1.getDeck().size()==0){
				window.getChildren().remove(P1DeckView);
		}
		if(player2.getDeck().size()==0){
				window.getChildren().remove(P2DeckView);		
		}
		P1DeckView.setLayoutX(1665);
		P1DeckView.setLayoutY(635);
		P2DeckView.setLayoutX(1665);
		P2DeckView.setLayoutY(335);
	}
	                         
	
	AnchorPane cardcreator(Card c){	
    newC = new AnchorPane();
    Image img = null;
    if(!c.getName().equals("Shadow Word: Death"))
    img = new Image(getClass().getResourceAsStream(c.getName()+".png"));
    else img = new Image(getClass().getResourceAsStream("Shadow Word Death.png"));
    ImageView pic = new ImageView(img);
    Image shield = new Image(getClass().getResourceAsStream("shield.png"));
    ImageView shieldP = new ImageView(shield);
    shieldP.setFitHeight(img.getHeight()-270);
    shieldP.setFitWidth(img.getWidth()-270);
    shieldP.setPreserveRatio(true);
    Image sleep = new Image(getClass().getResourceAsStream("zzz.gif"));
    ImageView zzzP = new ImageView(sleep);
    zzzP.setFitHeight(50);
    zzzP.setFitWidth(50);
    zzzP.setPreserveRatio(true);
    Image attacked = new Image(getClass().getResourceAsStream("Attack.gif"));
    ImageView attackedP = new ImageView(attacked);
    attackedP.setFitHeight(50);
    attackedP.setFitWidth(50);
    attackedP.setPreserveRatio(true);
    pic.setFitHeight(img.getHeight()-225);
    pic.setFitWidth(img.getWidth()-225);
    pic.setPreserveRatio(true);
    newC.setPrefHeight(img.getHeight());
    newC.setMaxSize(img.getWidth()-225,img.getHeight()-225);
    newC.setPrefWidth(img.getWidth());
    newC.getChildren().add(pic);
    
    manapts = new SimpleIntegerProperty(c.getManaCost());
    mana = new SimpleIntegerProperty();
    mana.bind(manapts);
    manaF = new Label();
    manaF.setTextFill(Color.WHITE);
    manaF.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    manaF.setText(""+mana.getValue().intValue());
    newC.getChildren().add(manaF);
    
    if(c instanceof Minion && c.getRarity().equals(Rarity.LEGENDARY)&&c.getManaCost()>=10){
    	manaF.setLayoutX(15);
        manaF.setLayoutY(24);
    }
    else if(c instanceof Minion && c.getRarity().equals(Rarity.LEGENDARY)&&c.getManaCost()<10){
    	manaF.setLayoutX(22);
        manaF.setLayoutY(24);
    }
    else if(c instanceof Spell && c.getManaCost()>=10){
    	manaF.setLayoutX(14);
        manaF.setLayoutY(13);
    }
    else if (c instanceof Spell && c.getManaCost()<10){
    	manaF.setLayoutX(20);
        manaF.setLayoutY(13);
    }
    else{
    	manaF.setLayoutX(21);
    	manaF.setLayoutY(11);
    }
    if(c instanceof Minion){
    	
    hppts = new SimpleIntegerProperty(((Minion) c).getCurrentHP());
    hp = new SimpleIntegerProperty();
    hp.bind(hppts);
    hpF = new Label();
    hpF.setTextFill(Color.WHITE);
    hpF.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    hpF.setText(""+hp.getValue().intValue());
    newC.getChildren().add(hpF);
    if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getCurrentHP()>=10){
    	 hpF.setLayoutX(138);
         hpF.setLayoutY(213);
    }
    else if(c.getRarity().equals (Rarity.LEGENDARY)&&((Minion) c).getCurrentHP()<10){
    	 hpF.setLayoutX(147);
         hpF.setLayoutY(211);
         }
     else{
    	 hpF.setLayoutX(147);
    	 hpF.setLayoutY(200);
     }
    atkpts = new SimpleIntegerProperty(((Minion) c).getAttack());
    atk = new SimpleIntegerProperty();
    atk.bind(atkpts);
    atkF = new Label();
    atkF.setTextFill(Color.WHITE);
    atkF.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    atkF.setText(""+atk.getValue().intValue());
    newC.getChildren().add(atkF);
   		if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getAttack()>=10){
   			atkF.setLayoutX(16);
   			atkF.setLayoutY(210);
   }
   	else if(c.getRarity().equals(Rarity.LEGENDARY)&&((Minion) c).getAttack()<10){
   	 		atkF.setLayoutX(22);
   	 		atkF.setLayoutY(210);
        }
    else{
    		atkF.setLayoutX(22);
    		atkF.setLayoutY(198);
   }
   		if(((Minion) c).isDivine()){
   			newC.getChildren().add(shieldP);
   			shieldP.setLayoutX(25);
    }
   		if(PolymorphedLegend){
            manaF.setLayoutX(22);
            manaF.setLayoutY(13);
            hpF.setLayoutX(147);
            hpF.setLayoutY(200);
            atkF.setLayoutX(22);
            atkF.setLayoutY(200);
            PolymorphedLegend=false;
        }

   		
   		if(((Minion)c).isSleeping()&&(player1.getField().contains(c) || player2.getField().contains(c))){
            newC.getChildren().add(zzzP);
            zzzP.setLayoutX(120);
            zzzP.setLayoutY(-20);
        }
        if(!((Minion)c).isAttacked()&& !((Minion)c).isSleeping() &&(player1.getField().contains(c) || player2.getField().contains(c))){
            newC.getChildren().add(attackedP);
            attackedP.setLayoutX(120);
            attackedP.setLayoutY(-20);
        }
        if(((Minion)c).isAttacked()  && newC.getChildren().contains(attackedP))
            newC.getChildren().remove(attackedP);
    }
    return newC;
    }

	public void onGameOver() {
		
		ColorAdjust darken = new ColorAdjust();
        darken.setBrightness(-1);
        transparent = new Image(getClass().getResourceAsStream("Transparent.png"));
        transparentView = new ImageView(transparent);
        transparentView.setEffect(darken);
        window.getChildren().add(transparentView);
        winnerName = new Label();
        winnerName.setFont(Font.font("Showcard Gothic", FontWeight.BOLD, 40));
        winnerName.setTextFill(Color.WHITE);
            if(player1.getCurrentHP()<=0){
                if(player2.getName().equals("Gul'dan"))
                winner = new Image(getClass().getResourceAsStream("Guldan.gif"));
                else 
                winner = new Image(getClass().getResourceAsStream(player2.getName()+".gif"));
                if(Player2Name.getText().equals(""))
                    winnerName.setText("Player 2 Wins!");
                else
                    winnerName.setText(Player2Name.getText()+"\n"+" Wins!");
                if(SFX)
                	DeathClip1.play();
            }
            else if(player2.getCurrentHP()<=0){
                    if(player1.getName().equals("Gul'dan"))
                    winner = new Image(getClass().getResourceAsStream("Guldan.gif"));
                    else 
                    winner = new Image(getClass().getResourceAsStream(player1.getName()+".gif"));
                    if(Player1Name.getText().equals(""))
                        winnerName.setText("Player 1 Wins!");
                    else
                        winnerName.setText(Player1Name.getText()+"\n"+" Wins!");
                    if(SFX)
                    	DeathClip2.play();
                }
                winnerView = new ImageView (winner);
                winnerView.setLayoutX(770);
                winnerName.setLayoutX(750);
                winnerName.setLayoutY(390);
                window.getChildren().addAll(winnerView,winnerName,playAgainView,QuitView);
                OverTimeMusic.stop();
                if(Music)
                	GameOverMusic.play();
		
	}
	void PlayAttack (String n){
		n = n.replaceAll(" ","");
		attackSound = new AudioClip("file:Sounds/"+n+"Attack.wav");
		attackSound.setVolume(0.5);
		attackSound.play();
	}
	void PlaySummon (String n){
		n = n.replaceAll(" ","");
		AudioClip summonsound = new AudioClip("file:Sounds/"+n+"Summon.wav");
		summonsound.setVolume(0.5);
		summonsound.play();
	}
}

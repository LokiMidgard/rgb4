package de.fhtrier.gdig.demos.jumpnrun.common.events;

import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import de.fhtrier.gdig.demos.jumpnrun.common.RGB4Game;
import de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.Team;
import de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.Player;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.Assets;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.GameStates;
import de.fhtrier.gdig.engine.sound.SoundManager;

public class WonGameEvent extends Event {

	private Player winningPlayer;
	private Team winningTeam;

	public WonGameEvent(Player winningPlayer) {
		super();

		this.winningTeam = null;
		this.winningPlayer = winningPlayer;
	}

	public WonGameEvent(Team winningTeam) {
		super();
		this.winningPlayer = null;
		this.winningTeam = winningTeam;
	}

	@Override
	public void update() {
		if (winningPlayer != null) {
			System.out.println(winningPlayer.getPlayerCondition().getName()
					+ " won.");
		}
		if (winningTeam != null) {
			System.out.println("Team " + winningTeam.id + " won.");
		}
		SoundManager.playSound(Assets.Sounds.DoomsdayDeviceSoundId);
		RGB4Game.getInstance().enterState(GameStates.GAMEOVER,
				new FadeOutTransition(), new FadeInTransition());
	}
}
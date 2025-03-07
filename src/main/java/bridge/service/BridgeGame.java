package bridge.service;

import bridge.domain.Bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private final Bridge bridge;
	private final int totalPhase;
	private int currentPhase;

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public BridgeGame(Bridge bridge, int totalPhase) {
		this.bridge = bridge;
		this.totalPhase = totalPhase;
		this.currentPhase = 0;
	}

	public void move(String userSelectedCell) {
		if (!isMovable(bridge, userSelectedCell)) {
			PauseGame.setPause();
		}
		if (isMovable(bridge, userSelectedCell)) {
			currentPhase++;
		}
	}

	public boolean isMovable(Bridge bridge, String userSelectedCell) {
		return bridge.isEquals(userSelectedCell, currentPhase);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		currentPhase = 0;
		PauseGame.unsetPause();
	}

	public void end() {
		currentPhase = totalPhase;
	}

	public boolean isEnd() {
		return currentPhase == totalPhase;
	}

	public String getBridgeLetter() {
		return bridge.findLetter(currentPhase);
	}
}

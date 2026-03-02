package com.narxoz.rpg.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class BattleEngine {
    private static BattleEngine instance;
    private Random random = new Random(1L);

    private BattleEngine() {
    }

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public BattleEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public void reset() {
        this.random = new Random(1L);
    }

    public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB) {
        if (teamA == null || teamB == null || teamA.isEmpty() || teamB.isEmpty()) {
            EncounterResult result = new EncounterResult();
            result.setWinner("No Contest");
            result.setRounds(0);
            result.addLog("Battle cancelled: both teams must have at least one combatant.");
            return result;
        }

        List<Combatant> aliveA = new ArrayList<>(teamA);
        List<Combatant> aliveB = new ArrayList<>(teamB);
        EncounterResult result = new EncounterResult();
        int round = 0;

        result.addLog("=== Battle Start ===");
        result.addLog("Team A: " + formatTeam(aliveA));
        result.addLog("Team B: " + formatTeam(aliveB));
        result.addLog("");

        while (!aliveA.isEmpty() && !aliveB.isEmpty()) {
            round++;
            result.addLog("--- Round " + round + " ---");

            attackPhase(aliveA, aliveB, result);
            aliveB.removeIf(c -> !c.isAlive());

            if (!aliveB.isEmpty()) {
                attackPhase(aliveB, aliveA, result);
                aliveA.removeIf(c -> !c.isAlive());
            }

            result.addLog("");
        }

        String winner = aliveA.isEmpty() ? "Team B" : "Team A";
        result.setWinner(winner);
        result.setRounds(round);
        result.addLog("=== " + winner + " wins in " + round + " round(s)! ===");

        return result;
    }

    private void attackPhase(List<Combatant> attackers, List<Combatant> defenders, EncounterResult result) {
        for (Combatant attacker : attackers) {
            if (defenders.isEmpty()) {
                break;
            }
            Combatant target = defenders.get(random.nextInt(defenders.size()));
            int damage = attacker.getAttackPower();
            target.takeDamage(damage);
            result.addLog(attacker.getName() + " attacks " + target.getName() + " for " + damage + " damage.");
            if (!target.isAlive()) {
                result.addLog(target.getName() + " has been defeated!");
                defenders.remove(target);
            }
        }
    }

    private String formatTeam(List<Combatant> team) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < team.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(team.get(i).getName());
        }
        return sb.toString();
    }
}

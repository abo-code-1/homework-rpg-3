package com.narxoz.rpg;

import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.adapter.HeroCombatantAdapter;
import com.narxoz.rpg.battle.BattleEngine;
import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.battle.EncounterResult;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.enemy.Orc;
import com.narxoz.rpg.enemy.Skeleton;
import com.narxoz.rpg.hero.Mage;
import com.narxoz.rpg.hero.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Battle Engine Demo ===\n");

        System.out.println("--- Singleton Pattern Demo ---");
        BattleEngine engineA = BattleEngine.getInstance();
        BattleEngine engineB = BattleEngine.getInstance();
        System.out.println("Engine A: " + engineA);
        System.out.println("Engine B: " + engineB);
        System.out.println("Same instance? " + (engineA == engineB));
        System.out.println();

        System.out.println("--- Adapter Pattern Demo ---");
        Warrior warrior = new Warrior("Arthas");
        Mage mage = new Mage("Jaina");
        Goblin goblin = new Goblin();
        Orc orc = new Orc();
        Skeleton skeleton = new Skeleton();

        List<Combatant> heroes = new ArrayList<>();
        heroes.add(new HeroCombatantAdapter(warrior));
        heroes.add(new HeroCombatantAdapter(mage));

        List<Combatant> enemies = new ArrayList<>();
        enemies.add(new EnemyCombatantAdapter(goblin));
        enemies.add(new EnemyCombatantAdapter(orc));
        enemies.add(new EnemyCombatantAdapter(skeleton));

        System.out.println("Heroes (via HeroCombatantAdapter):");
        for (Combatant c : heroes) {
            System.out.println("  " + c.getName() + " | Attack: " + c.getAttackPower() + " | Alive: " + c.isAlive());
        }
        System.out.println("Enemies (via EnemyCombatantAdapter):");
        for (Combatant c : enemies) {
            System.out.println("  " + c.getName() + " | Attack: " + c.getAttackPower() + " | Alive: " + c.isAlive());
        }
        System.out.println();

        System.out.println("--- Battle Simulation ---");
        engineA.setRandomSeed(42L);
        EncounterResult result = engineA.runEncounter(heroes, enemies);

        for (String line : result.getBattleLog()) {
            System.out.println(line);
        }
        System.out.println();

        System.out.println("--- Battle Summary ---");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Total Rounds: " + result.getRounds());

        System.out.println("\n=== Demo Complete ===");
    }
}

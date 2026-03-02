# Project Progress Tracker

## Current Status: Step 1 [COMPLETED]

## Branch Mapping
- `feature/prepare-base-classes` → Steps 1–4
- `feature/add-enemy-types` → Step 5
- `feature/battle-engine-logic` → Steps 6–7
- `feature/main-demo-integration` → Steps 8–10

## Step Breakdown

### Step 1: Clean Hero classes [COMPLETED]
- [x] Remove all comments from Warrior.java
- [x] Remove all comments from Mage.java

### Step 2: Clean Enemy classes [PENDING]
- [ ] Remove all comments from BasicEnemy.java
- [ ] Remove all comments from Goblin.java

### Step 3: Finalize HeroCombatantAdapter [PENDING]
- [ ] Remove TODO comment from HeroCombatantAdapter.java

### Step 4: Finalize EnemyCombatantAdapter [PENDING]
- [ ] Remove TODO comment from EnemyCombatantAdapter.java

### Step 5: Add new enemy types [PENDING]
- [ ] Create Orc.java
- [ ] Create Skeleton.java

### Step 6: Implement BattleEngine.reset() [PENDING]
- [ ] Implement reset method

### Step 7: Implement BattleEngine.runEncounter() [PENDING]
- [ ] Validate inputs
- [ ] Round-based attack logic
- [ ] Remove dead combatants
- [ ] End condition and result

### Step 8: Update Main.java [PENDING]
- [ ] Singleton demonstration
- [ ] Adapter usage
- [ ] Full battle with readable output

### Step 9: Compile and test [PENDING]
- [ ] Verify compilation
- [ ] Verify runtime output

### Step 10: Final polish [PENDING]
- [ ] No TODOs remain
- [ ] Output is clean and readable

## Files Modified/Created

### Step 1:
- `src/com/narxoz/rpg/hero/Warrior.java` - MODIFIED
- `src/com/narxoz/rpg/hero/Mage.java` - MODIFIED

## Project Structure (Target)
```
homework_rpg_3/
├── src/
│   └── com/
│       └── narxoz/
│           └── rpg/
│               ├── Main.java
│               ├── battle/
│               │   ├── BattleEngine.java
│               │   ├── Combatant.java
│               │   └── EncounterResult.java
│               ├── adapter/
│               │   ├── HeroCombatantAdapter.java
│               │   └── EnemyCombatantAdapter.java
│               ├── hero/
│               │   ├── Hero.java
│               │   ├── Warrior.java
│               │   └── Mage.java
│               ├── enemy/
│               │   ├── Enemy.java
│               │   ├── BasicEnemy.java
│               │   ├── Goblin.java
│               │   ├── Orc.java
│               │   └── Skeleton.java
│               └── hints/
```

## Design Patterns / Architecture Used
- **Singleton**: BattleEngine — single global instance, private constructor, getInstance()
- **Adapter**: HeroCombatantAdapter / EnemyCombatantAdapter — translate Hero/Enemy APIs to Combatant interface

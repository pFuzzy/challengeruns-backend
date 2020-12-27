package com.codecool.challengerunsbackend;

import com.codecool.challengerunsbackend.entity.*;
import com.codecool.challengerunsbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ChallengeRunsBackendApplication {

    @Autowired
    private GameRepository gameRepository;

    public static void main(String[] args) {
        SpringApplication.run(ChallengeRunsBackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            //--------------------------------
            Area asylum1 = Area.builder()
                    .name("Northern Undead Asylum")
                    .pickUp("Longsword")
                    .enemy("Hollow x3")
                    .enemy("Asylum demon")
                    .build();
            Split asylum = Split.builder()
                    .name("Asylum demon")
                    .area(asylum1)
                    .build();
            asylum1.setSplit(asylum);
            //--------------------------------


            Area quelaag1 = Area.builder()
                    .name("Northern Undead Asylum")
                    .build();
            Area quelaag2 = Area.builder()
                    .name("Firelink Shrine")
                    .pickUp("Humanity x3")
                    .pickUp("Homeward bone x6")
                    .pickUp("Lloyd's talisman x4")
                    .build();
            Area quelaag3 = Area.builder()
                    .name("New Londo Ruins")
                    .pickUp("Soul of a Nameless Soldier")
                    .build();
            Area quelaag4 = Area.builder()
                    .name("Valley of Drakes")
                    .pickUp("Large Soul of a Nameless Soldier")
                    .pickUp("Soul of a Proud Knight")
                    .pickUp("Red Tearstone Ring")
                    .tip("You can rest at the Darkroot Basin bonfire and Homeward Bone" +
                            " to it after picking up Red Tearstone Ring")
                    .build();
            Area quelaag5 = Area.builder()
                    .name("Darkroot Basin")
                    .pickUp("Grass Crest Shield")
                    .pickUp("Longbow")
                    .enemy("Black Knight")
                    .enemy("Crystal Lizard")
                    .tip("You can backstab the Black Knight to knock him off the cliff")
                    .build();
            Area quelaag6 = Area.builder()
                    .name("Darkroot Garden")
                    .tip("Optional: you can farm Purple Moss Clump from Ents after using your" +
                            " humanities to help you set up RTS for Quelaag.")
                    .build();
            Area quelaag7 = Area.builder()
                    .name("Undead Parish")
                    .pickUp("Halberd")
                    .upgrade("Halberd +4")
                    .tip("Use your souls and buy 5 Titanite Shards from Andre of Astora.")
                    .build();
            Area quelaag8 = Area.builder().name("Firelink Shrine").build();
            Area quelaag9 = Area.builder().name("New Londo Ruins").build();
            Area quelaag10 = Area.builder().name("Valley of Drakes").build();
            Area quelaag11 = Area.builder().name("Blighttown").build();
            Area quelaag12 = Area.builder()
                    .name("Quelaag's Domain")
                    .enemy("Chaos Witch Quelaag")
                    .tip("If you didn't pick up Purple Moss Clump wait for the poison effect " +
                            "to tick down until the first bar fully heal and wait for RTSR.")
                    .build();
            Split quelaag = Split.builder()
                    .name("Chaos witch Quelaag")
                    .area(quelaag1)
                    .area(quelaag2)
                    .area(quelaag3)
                    .area(quelaag4)
                    .area(quelaag5)
                    .area(quelaag6)
                    .area(quelaag7)
                    .area(quelaag8)
                    .area(quelaag9)
                    .area(quelaag10)
                    .area(quelaag11)
                    .area(quelaag12)
                    .build();
            quelaag1.setSplit(quelaag);
            quelaag2.setSplit(quelaag);
            quelaag3.setSplit(quelaag);
            quelaag4.setSplit(quelaag);
            quelaag5.setSplit(quelaag);
            quelaag6.setSplit(quelaag);
            quelaag7.setSplit(quelaag);
            quelaag8.setSplit(quelaag);
            quelaag9.setSplit(quelaag);
            quelaag10.setSplit(quelaag);
            quelaag11.setSplit(quelaag);
            quelaag12.setSplit(quelaag);
            //--------------------------------


            Area ceaseless1 = Area.builder()
                    .name("Quelaag's Domain")
                    .tip("Ring the Bell of Awakening")
                    .build();
            Area ceaseless2 = Area.builder()
                    .name("Demon Ruins")
                    .enemy("Ceaseless Discharge")
                    .build();
            Split ceaseless = Split.builder()
                    .name("Ceaseless Discharge")
                    .area(ceaseless1)
                    .area(ceaseless2)
                    .build();
            ceaseless1.setSplit(ceaseless);
            ceaseless2.setSplit(ceaseless);
            //--------------------------------


            Area gargoyles1 = Area.builder()
                    .name("Demon Ruins")
                    .build();
            Area gargoyles2 = Area.builder()
                    .name("Undead Parish")
                    .enemy("Hollow Soldier x3")
                    .enemy("Berenike Knight")
                    .enemy("Balder Knight")
                    .enemy("Hollow x10")
                    .enemy("Channeler")
                    .enemy("Bell Gargoyles")
                    .pickUp("Fire Keeper Soul")
                    .acquiredLevel("Endurance: 20")
                    .acquiredLevel("Strength: 16")
                    .acquiredLevel("Dexterity: 22")
                    .upgrade("Halberd +5")
                    .upgrade("Longbow +5")
                    .tip("After leveling and upgrading spennd all your souls on Large Arrows " +
                            "(about 120 arrows)")
                    .build();
            Split gargoyles = Split.builder()
                    .name("Bell Gargoyles")
                    .area(gargoyles1)
                    .area(gargoyles2)
                    .build();
            gargoyles1.setSplit(gargoyles);
            gargoyles2.setSplit(gargoyles);
            //--------------------------------


            Area golem1 = Area.builder()
                    .name("Undead Parish")
                    .enemy("Andre of Astora")
                    .pickUp("Crest of Artorias")
                    .pickUp("Humanity x3")
                    .tip("Ring the Bell of Awakening and buy 4 Homeward bones " +
                            "from Oswald of Carim")
                    .build();
            Area golem2 = Area.builder()
                    .name("Darkroot Garden")
                    .enemy("Ent x4")
                    .enemy("Ninja bodyguard of Shiva")
                    .pickUp("Dark Woodgrain Ring")
                    .pickUp("Humanity")
                    .build();
            Area golem3 = Area.builder()
                    .name("Undead Parish")
                    .build();
            Area golem4 = Area.builder()
                    .name("Sen's Fortress")
                    .enemy("Man Serpent x5")
                    .enemy("Serpent Mage x3")
                    .enemy("Mimic")
                    .enemy("Undead Knight Archer")
                    .enemy("Firebomb Giant")
                    .enemy("Iron Golem")
                    .pickUp("Soul of a Brave Warrior")
                    .pickUp("Slumbering Dragoncrest Ring")
                    .pickUp("Large Soul of a Brave Warrior")
                    .pickUp("Large Titanite Shard x2")
                    .pickUp("Titanite Chunk")
                    .tip("Use your Lloyd's talismans on the mimic and pick up " +
                            "Symbol of Avarice if it drops")
                    .build();
            Split golem = Split.builder()
                    .name("Iron Golem")
                    .area(golem1)
                    .area(golem2)
                    .area(golem3)
                    .area(golem4)
                    .build();
            golem1.setSplit(golem);
            golem2.setSplit(golem);
            golem3.setSplit(golem);
            golem4.setSplit(golem);
            //--------------------------------
            Area ornstein1 = Area.builder()
                    .name("Sen's Fortress")
                    .build();
            Area ornstein2 = Area.builder()
                    .name("Anor Londo")
                    .enemy("Mimic x2")
                    .enemy("Painted guardian x5")
                    .enemy("Gargoyle")
                    .enemy("Bat Wing Demon x5")
                    .enemy("Silver Knight")
                    .enemy("Executioner Smough and Dragon Slayer Ornstein")
                    .pickUp("Crystal Halberd")
                    .acquiredLevel("Dexterity: 30")
                    .acquiredLevel("Endurance: rest of your souls")
                    .tip("If the second Mimic doesn't drop Symbol of Avarice" +
                            " kill the third one too.")
                    .build();
            Split ornstein = Split.builder()
                    .name("Dragonslayer Ornstein and Executioner Smough")
                    .area(ornstein1)
                    .area(ornstein2)
                    .build();
            ornstein1.setSplit(ornstein);
            ornstein2.setSplit(ornstein);
            //--------------------------------

            Area pinwheel1 = Area.builder()
                    .name("Anor Londo")
                    .acquiredLevel("Endurance: 27")
                    .acquiredLevel("Dexterity: 36")
                    .acquiredLevel("From this point work your way to 40 Dexterity and " +
                            "40 Endurance")
                    .tip("Kill Princess Gwynevere to acquire Lordvessel")
                    .build();
            Area pinwheel2 = Area.builder()
                    .name("Firelink Shrine")
                    .build();
            Area pinwheel3 = Area.builder()
                    .name("Firelink Altar")
                    .tip("Place Lordvessel")
                    .build();
            Area pinwheel4 = Area.builder()
                    .name("Firelink Shrine")
                    .build();
            Area pinwheel5 = Area.builder()
                    .name("Catacombs")
                    .enemy("Necromancer x2")
                    .enemy("Skeleton x5")
                    .enemy("Pinwheel")
                    .tip("Make some noise by hitting the rock to distract Bonewheels")
                    .build();
            Split pinwheel = Split.builder()
                    .name("Pinwheel")
                    .area(pinwheel1)
                    .area(pinwheel2)
                    .area(pinwheel3)
                    .area(pinwheel4)
                    .area(pinwheel5)
                    .build();
            pinwheel1.setSplit(pinwheel);
            pinwheel2.setSplit(pinwheel);
            pinwheel3.setSplit(pinwheel);
            pinwheel4.setSplit(pinwheel);
            pinwheel5.setSplit(pinwheel);

            //--------------------------------

            Area nito1 = Area.builder()
                    .name("Catacombs")
                    .build();
            Area nito2 = Area.builder()
                    .name("Tomb of the Giants")
                    .pickUp("Humanity x5")
                    .pickUp("Skull Lantern")
                    .enemy("Patches")
                    .build();
            Area nito3 = Area.builder()
                    .name("Firelink Shrine")
                    .enemy("Hollow Warrior x4")
                    .enemy("Undead Soldier")
                    .pickUp("Ring of Sacrifice")
                    .build();
            Area nito4 = Area.builder()
                    .name("Northern Undead Asylum")
                    .enemy("Hollow x4")
                    .tip("Trade Skull Lantern for Fog Ring at Snuggly (you have to " +
                            "Homeward bone out and come back)")
                    .build();
            Area nito5 = Area.builder()
                    .name("Tomb of the Giants")
                    .enemy("Pinwheel x2")
                    .enemy("Gravelord Nito")
                    .tip("Equip Slumbering Dragoncrest Ring and Fog ring after" +
                            "fog gate but before dropping down")
                    .build();
            Split nito = Split.builder()
                    .name("Gravelord Nito")
                    .area(nito1)
                    .area(nito2)
                    .area(nito3)
                    .area(nito4)
                    .area(nito5)
                    .build();
            nito1.setSplit(nito);
            nito2.setSplit(nito);
            nito3.setSplit(nito);
            nito4.setSplit(nito);
            nito5.setSplit(nito);

            //--------------------------------

            Area sif1 = Area.builder()
                    .name("Tomb of the Giants")
                    .build();
            Area sif2 = Area.builder()
                    .name("Anor Londo")
                    .upgrade("Crystal Halberd +2")
                    .build();
            Area sif3 = Area.builder()
                    .name("Undead Parish")
                    .build();
            Area sif4 = Area.builder()
                    .name("Darkroot Garden")
                    .enemy("Great Grey Wolf Sif")
                    .pickUp("Hornet Ring")
                    .build();
            Split sif = Split.builder()
                    .name("Great Grey Wolf Sif")
                    .area(sif1)
                    .area(sif2)
                    .area(sif3)
                    .area(sif4)
                    .build();
            sif1.setSplit(sif);
            sif2.setSplit(sif);
            sif3.setSplit(sif);
            sif4.setSplit(sif);

            //--------------------------------

            Area seath1 = Area.builder()
                    .name("Darkroot Garden")
                    .build();
            Area seath2 = Area.builder()
                    .name("Anor Londo")
                    .enemy("Fang Boar")
                    .build();
            Area seath3 = Area.builder()
                    .name("The Duke's Archives")
                    .tip("Equip Ring of Sacrifice before going through Seath fog gate." +
                            "Getting hit here is unavoidable in order to progress through" +
                            "the game!")
                    .build();
            Area seath4 = Area.builder()
                    .name("The Duke's Archives (Prison)")
                    .enemy("Man Serpent x2")
                    .enemy("Serpent Mage")
                    .pickUp("Archive Tower Giant Door Key")
                    .build();
            Area seath5 = Area.builder()
                    .name("The Duke's Archives")
                    .enemy("Channeler x2")
                    .enemy("Undead Crystal Archer x4")
                    .build();
            Area seath6 = Area.builder()
                    .name("Crystal Cave")
                    .enemy("Man-Eater Shell x5")
                    .enemy("Seath the Scaleless")
                    .build();
            Split seath = Split.builder()
                    .name("Seath the scaleless")
                    .area(seath1)
                    .area(seath2)
                    .area(seath3)
                    .area(seath4)
                    .area(seath5)
                    .area(seath6)
                    .build();
            seath1.setSplit(seath);
            seath2.setSplit(seath);
            seath3.setSplit(seath);
            seath4.setSplit(seath);
            seath5.setSplit(seath);
            seath6.setSplit(seath);


            //--------------------------------

            Area boc1 = Area.builder()
                    .name("Crystal Cave")
                    .build();
            Area boc2 = Area.builder()
                    .name("Firelink Shrine")
                    .pickUp("Firebomb x4")
                    .build();
            Area boc3 = Area.builder()
                    .name("New Londo Ruins")
                    .build();
            Area boc4 = Area.builder()
                    .name("Valley of Drake")
                    .build();
            Area boc5 = Area.builder()
                    .name("Blighttown")
                    .build();
            Area boc6 = Area.builder()
                    .name("Quelaag's Domain")
                    .tip("Join Chaos Servent covenant and give the Daughter of Chaos 30" +
                            " humanities to unlock shortcut to Bed of Chaos")
                    .build();
            Area boc7 = Area.builder()
                    .name("Demon Ruins")
                    .enemy("Stone demon x5")
                    .build();
            Area boc8 = Area.builder()
                    .name("Lost Izalith")
                    .enemy("Bed of Chaos")
                    .build();
            Split boc = Split.builder()
                    .name("Bed of chaos")
                    .area(boc1)
                    .area(boc2)
                    .area(boc3)
                    .area(boc4)
                    .area(boc5)
                    .area(boc6)
                    .area(boc7)
                    .area(boc8)
                    .build();
            boc1.setSplit(boc);
            boc2.setSplit(boc);
            boc3.setSplit(boc);
            boc4.setSplit(boc);
            boc5.setSplit(boc);
            boc6.setSplit(boc);
            boc7.setSplit(boc);
            boc8.setSplit(boc);


            //--------------------------------

            Area fourKings1 = Area.builder()
                    .name("Lost Izalith")
                    .build();
            Area fourKings2 = Area.builder()
                    .name("Firelink Shrine")
                    .build();
            Area fourKings3 = Area.builder()
                    .name("New Londo Ruins")
                    .pickUp("Transient Curse x3")
                    .enemy("Ghost x8")
                    .enemy("Ingward")
                    .tip("Make sure to equip Covenant of Artorias before dropping.")
                    .build();
            Area fourKings4 = Area.builder()
                    .name("The Abyss")
                    .enemy("Four Kings")
                    .build();
            Split fourKings = Split.builder()
                    .name("Four kings")
                    .area(fourKings1)
                    .area(fourKings2)
                    .area(fourKings3)
                    .area(fourKings4)
                    .build();
            fourKings1.setSplit(fourKings);
            fourKings2.setSplit(fourKings);
            fourKings3.setSplit(fourKings);
            fourKings4.setSplit(fourKings);

            //--------------------------------

            Area gwyn1 = Area.builder()
                    .name("The Abyss")
                    .build();
            Area gwyn2 = Area.builder()
                    .name("Firelink Shrine")
                    .build();
            Area gwyn3 = Area.builder()
                    .name("Firelink Altar")
                    .build();
            Area gwyn4 = Area.builder()
                    .name("Kiln of the first flame")
                    .enemy("Gwyn, Lord of Cinder")
                    .tip("Make sure to equip hornet ring before entering the fog gate.")
                    .build();
            Split gwyn = Split.builder()
                    .name("Gwyn, Lord of Cinder")
                    .area(gwyn1)
                    .area(gwyn2)
                    .area(gwyn3)
                    .area(gwyn4)
                    .build();
            gwyn1.setSplit(gwyn);
            gwyn2.setSplit(gwyn);
            gwyn3.setSplit(gwyn);
            gwyn4.setSplit(gwyn);

            //--------------------------------
            Run ds1Any = Run.builder()
                    .name("Any%")
                    .category("No-hit")
                    .split(asylum)
                    .split(quelaag)
                    .split(ceaseless)
                    .split(gargoyles)
                    .split(golem)
                    .split(ornstein)
                    .split(pinwheel)
                    .split(nito)
                    .split(sif)
                    .split(seath)
                    .split(boc)
                    .split(fourKings)
                    .split(gwyn)
                    .build();
            Run allBosses = Run.builder()
                    .name("All bosses")
                    .category("No-hit")
                    .build();

            Run anyPercentNoDmg = Run.builder()
                    .name("Any%")
                    .category("No-damage")
                    .build();

            Run allBossesNoDmg = Run.builder()
                    .name("All bosses")
                    .category("No-damage")
                    .build();

            Game ds1 = Game.builder()
                    .title("Dark souls 1")
                    .run(ds1Any)
                    .run(anyPercentNoDmg)
                    .run(allBosses)
                    .run(allBossesNoDmg)
                    .build();

            asylum.setRun(ds1Any);
            quelaag.setRun(ds1Any);
            ceaseless.setRun(ds1Any);
            gargoyles.setRun(ds1Any);
            golem.setRun(ds1Any);
            ornstein.setRun(ds1Any);
            pinwheel.setRun(ds1Any);
            nito.setRun(ds1Any);
            sif.setRun(ds1Any);
            seath.setRun(ds1Any);
            boc.setRun(ds1Any);
            fourKings.setRun(ds1Any);
            gwyn.setRun(ds1Any);


            allBosses.setGame(ds1);
            allBossesNoDmg.setGame(ds1);
            anyPercentNoDmg.setGame(ds1);
            ds1Any.setGame(ds1);

            gameRepository.save(ds1);

            Game ds2 = Game.builder()
                    .title("Dark souls 2")
                    .build();

            Game ds3 = Game.builder()
                    .title("Dark souls 3")
                    .build();

            Game sekiro = Game.builder()
                    .title("Sekiro")
                    .build();
            Game jedi = Game.builder()
                    .title("Jedi fallen order")
                    .build();

            List<Game> games = new ArrayList<>();
            games.add(ds2);
            games.add(ds3);
            games.add(sekiro);
            games.add(jedi);

            gameRepository.saveAll(games);


        };
    }
}

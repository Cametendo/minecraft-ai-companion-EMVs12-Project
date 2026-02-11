package ollamacompanion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import com.mojang.brigadier.arguments.StringArgumentType;

public class OllamaCompanion implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("[OllamaCompanion] MOD STARTET!");

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            System.out.println("[OllamaCompanion] Registriere /ai command");

            dispatcher.register(
                    CommandManager.literal("ai")
                            .then(CommandManager.argument("frage", StringArgumentType.greedyString())
                                    .executes(ctx -> {
                                        var player = ctx.getSource().getPlayer();
                                        String frage = StringArgumentType.getString(ctx, "frage");

                                        player.sendMessage(Text.literal("§6[AI] §fDu fragtest: " + frage), false);
                                        return 1;
                                    })
                            )
            );
        });

        System.out.println("[OllamaCompanion] MOD GELADEN!");
    }
}

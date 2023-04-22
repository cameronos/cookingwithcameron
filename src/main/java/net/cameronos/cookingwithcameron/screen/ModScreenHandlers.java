package net.cameronos.cookingwithcameron.screen;

import net.cameronos.cookingwithcameron.CookingWithCameron;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
    public class ModScreenHandlers {
        public static ScreenHandlerType<DistilleryScreenHandler> DISTILLERY_SCREENHANDLER;

        public static void registerAllScreenHandlers() {
            DISTILLERY_SCREENHANDLER =
                    ScreenHandlerRegistry.registerSimple(new Identifier(CookingWithCameron.MOD_ID, "distillery"),
                            DistilleryScreenHandler::new);
        }
    }
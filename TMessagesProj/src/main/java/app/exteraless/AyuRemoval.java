package app.exteraless;

import tw.nekomimi.nekogram.NekoConfig;
import tw.nekomimi.nekogram.config.ConfigItem;
import xyz.nextalone.nagram.NaConfig;

/**
 * QuarkGram: AyuMoments (режим призрака, сохранение удалённых и изменённых сообщений,
 * regex-фильтры) убран из клиента. Интерфейса для этих функций больше нет, а здесь при каждом
 * запуске их настройки принудительно возвращаются в выключенное состояние, чтобы ничто не
 * сработало из восстановленной копии настроек или старых данных.
 */
public final class AyuRemoval {

    private AyuRemoval() {
    }

    private static void force(ConfigItem item, boolean value) {
        try {
            if (item.Bool() != value) {
                item.setConfigBool(value);
            }
        } catch (Throwable ignore) {
        }
    }

    public static void apply() {
        // Режим призрака: обычное поведение (читать, быть онлайн, показывать набор текста).
        force(NekoConfig.sendReadMessagePackets, true);
        force(NekoConfig.sendReadStoriesPackets, true);
        force(NekoConfig.sendOnlinePackets, true);
        force(NekoConfig.sendUploadProgress, true);
        force(NekoConfig.sendOfflinePacketAfterOnline, false);
        force(NekoConfig.markReadAfterSend, true);
        force(NekoConfig.showGhostInDrawer, false);
        force(NekoConfig.showGhostModeStatus, false);

        // Сохранение удалённого и изменённого, локальные «был в сети» и «прочитано», фильтры.
        final NaConfig na = NaConfig.INSTANCE;
        force(na.getEnableSaveDeletedMessages(), false);
        force(na.getEnableSaveEditsHistory(), false);
        force(na.getSaveLocalLastSeen(), false);
        force(na.getSaveReadDate(), false);
        force(na.getRegexFiltersEnabled(), false);
        force(na.getForwardProtectedAsCopy(), false);
        force(na.getAskBeforeOpeningStory(), false);
    }
}

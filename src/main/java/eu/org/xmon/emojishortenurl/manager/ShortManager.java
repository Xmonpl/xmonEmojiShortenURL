package eu.org.xmon.emojishortenurl.manager;

import eu.org.xmon.emojishortenurl.object.Short;
import eu.org.xmon.emojishortenurl.utils.EmojiGenerator;
import eu.org.xmon.emojishortenurl.utils.LoggerUtils;
import lombok.SneakyThrows;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Optional;

public class ShortManager {
    private final static LinkedHashSet<Short> shorts = new LinkedHashSet<Short>();

    public static Optional<Short> getShortByOrginalURL(final String orginalURL){
        return shorts.stream()
                .filter(x -> x.getOrginal$url().equals(orginalURL))
                .findFirst();
    }

    public static Optional<Short> getShortByEmojiURL(final String emojiURL){
        return shorts.stream()
                .filter(x -> x.getEmoji$url().equals(emojiURL))
                .findFirst();
    }

    public static Short createShortURL(final String orginalURL, final Integer emojiSize){
        String emojiURL = EmojiGenerator.getRandomEmoji(emojiSize);
        boolean use = true;
        do{
            if (getShortByEmojiURL(emojiURL).isEmpty()){
                use = false;
            }else{
                emojiURL = EmojiGenerator.getRandomEmoji(emojiSize);
            }
        }while (use);
        final Short shortURL = new Short(orginalURL, emojiURL);
        shorts.add(shortURL);
        return shortURL;
    }

    public void saveUrls() throws IOException {
        FileOutputStream fos = new FileOutputStream("urls.db");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(shorts);
        oos.close();
        fos.close();
        LoggerUtils.logger.info("Saved " + shorts.size() + " shorten urls!");
    }

    @SneakyThrows
    public void loadUsers(){
        if (new File("urls.db").exists()) {
            FileInputStream fis = new FileInputStream("urls.db");
            ObjectInputStream ois = new ObjectInputStream(fis);
            shorts.clear();
            shorts.addAll((LinkedHashSet) ois.readObject());
            ois.close();
            fis.close();
            LoggerUtils.logger.info("Loaded " + shorts.size() + " shorten urls!");
        }
    }
}

package encryption;

public class SlideEncryption implements IEncryption{
  private String encodedMsg;
  private final String originalMsg;


  public SlideEncryption(String msg) {
    this.encodedMsg = null;
    this.originalMsg = msg;
    if (originalMsg == null || originalMsg.equals("")) {
      throw new IllegalArgumentException("original message can not be empty or null");
    }
  }

  public String getEncodedMsg() {
    return this.encodedMsg;
  }

  public String getOriginalMsg() {
    return this.originalMsg;
  }

  @Override
  public String encode(int encoding) {
    if (encoding == 0) {
      return originalMsg;
    }
    char[] charsMsg = originalMsg.toCharArray();
    int l = charsMsg.length;
    char[] charsEn = new char[l];
    for (int i = 0; i < l; i++) {
      int j = (i - encoding % l + l) % l;
      charsEn[i] = charsMsg[j];
    }
    encodedMsg = new String(charsEn);
    return encodedMsg;
  }

  @Override
  public String toString() {
    return this.getEncodedMsg() + "\n" + this.getOriginalMsg();
  }
}

package b.a.a;

import c.e;
import c.g;
import c.h;
import c.i;
import c.p;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;

public final class ad
  implements ae
{
  static final byte[] a;
  
  static
  {
    try
    {
      a = "\000\000\000\007options\000\000\000\004head\000\000\000\004post\000\000\000\003put\000\000\000\006delete\000\000\000\005trace\000\000\000\006accept\000\000\000\016accept-charset\000\000\000\017accept-encoding\000\000\000\017accept-language\000\000\000\raccept-ranges\000\000\000\003age\000\000\000\005allow\000\000\000\rauthorization\000\000\000\rcache-control\000\000\000\nconnection\000\000\000\fcontent-base\000\000\000\020content-encoding\000\000\000\020content-language\000\000\000\016content-length\000\000\000\020content-location\000\000\000\013content-md5\000\000\000\rcontent-range\000\000\000\fcontent-type\000\000\000\004date\000\000\000\004etag\000\000\000\006expect\000\000\000\007expires\000\000\000\004from\000\000\000\004host\000\000\000\bif-match\000\000\000\021if-modified-since\000\000\000\rif-none-match\000\000\000\bif-range\000\000\000\023if-unmodified-since\000\000\000\rlast-modified\000\000\000\blocation\000\000\000\fmax-forwards\000\000\000\006pragma\000\000\000\022proxy-authenticate\000\000\000\023proxy-authorization\000\000\000\005range\000\000\000\007referer\000\000\000\013retry-after\000\000\000\006server\000\000\000\002te\000\000\000\007trailer\000\000\000\021transfer-encoding\000\000\000\007upgrade\000\000\000\nuser-agent\000\000\000\004vary\000\000\000\003via\000\000\000\007warning\000\000\000\020www-authenticate\000\000\000\006method\000\000\000\003get\000\000\000\006status\000\000\000\006200 OK\000\000\000\007version\000\000\000\bHTTP/1.1\000\000\000\003url\000\000\000\006public\000\000\000\nset-cookie\000\000\000\nkeep-alive\000\000\000\006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(b.a.j.c.name());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError();
    }
  }
  
  public b a(h paramh, boolean paramBoolean)
  {
    return new a(paramh, paramBoolean);
  }
  
  public c a(g paramg, boolean paramBoolean)
  {
    return new b(paramg, paramBoolean);
  }
  
  static final class a
    implements b
  {
    private final h a;
    private final boolean b;
    private final w c;
    
    a(h paramh, boolean paramBoolean)
    {
      this.a = paramh;
      this.c = new w(this.a);
      this.b = paramBoolean;
    }
    
    private static IOException a(String paramString, Object... paramVarArgs)
    {
      throw new IOException(String.format(paramString, paramVarArgs));
    }
    
    private void a(b.a parama, int paramInt1, int paramInt2)
    {
      boolean bool2 = true;
      int i = this.a.k();
      int j = this.a.k();
      this.a.j();
      List localList = this.c.a(paramInt2 - 10);
      boolean bool1;
      if ((paramInt1 & 0x1) != 0)
      {
        bool1 = true;
        if ((paramInt1 & 0x2) == 0) {
          break label95;
        }
      }
      for (;;)
      {
        parama.a(bool2, bool1, i & 0x7FFFFFFF, j & 0x7FFFFFFF, localList, s.a);
        return;
        bool1 = false;
        break;
        label95:
        bool2 = false;
      }
    }
    
    private void b(b.a parama, int paramInt1, int paramInt2)
    {
      int i = this.a.k();
      List localList = this.c.a(paramInt2 - 4);
      if ((paramInt1 & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        parama.a(false, bool, i & 0x7FFFFFFF, -1, localList, s.b);
        return;
      }
    }
    
    private void c(b.a parama, int paramInt1, int paramInt2)
    {
      if (paramInt2 != 8) {
        throw a("TYPE_RST_STREAM length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramInt1 = this.a.k();
      paramInt2 = this.a.k();
      a locala = a.a(paramInt2);
      if (locala == null) {
        throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      }
      parama.a(paramInt1 & 0x7FFFFFFF, locala);
    }
    
    private void d(b.a parama, int paramInt1, int paramInt2)
    {
      parama.a(false, false, this.a.k() & 0x7FFFFFFF, -1, this.c.a(paramInt2 - 4), s.c);
    }
    
    private void e(b.a parama, int paramInt1, int paramInt2)
    {
      if (paramInt2 != 8) {
        throw a("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramInt1 = this.a.k();
      long l = this.a.k() & 0x7FFFFFFF;
      if (l == 0L) {
        throw a("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
      }
      parama.a(paramInt1 & 0x7FFFFFFF, l);
    }
    
    private void f(b.a parama, int paramInt1, int paramInt2)
    {
      boolean bool2 = true;
      if (paramInt2 != 4) {
        throw a("TYPE_PING length: %d != 4", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramInt1 = this.a.k();
      boolean bool3 = this.b;
      if ((paramInt1 & 0x1) == 1)
      {
        bool1 = true;
        if (bool3 != bool1) {
          break label79;
        }
      }
      label79:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        parama.a(bool1, paramInt1, 0);
        return;
        bool1 = false;
        break;
      }
    }
    
    private void g(b.a parama, int paramInt1, int paramInt2)
    {
      if (paramInt2 != 8) {
        throw a("TYPE_GOAWAY length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramInt1 = this.a.k();
      paramInt2 = this.a.k();
      a locala = a.c(paramInt2);
      if (locala == null) {
        throw a("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      }
      parama.a(paramInt1 & 0x7FFFFFFF, locala, i.b);
    }
    
    private void h(b.a parama, int paramInt1, int paramInt2)
    {
      boolean bool = true;
      int i = this.a.k();
      if (paramInt2 != i * 8 + 4) {
        throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i) });
      }
      ac localac = new ac();
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        int j = this.a.k();
        localac.a(j & 0xFFFFFF, (0xFF000000 & j) >>> 24, this.a.k());
        paramInt2 += 1;
      }
      if ((paramInt1 & 0x1) != 0) {}
      for (;;)
      {
        parama.a(bool, localac);
        return;
        bool = false;
      }
    }
    
    public void a() {}
    
    public boolean a(b.a parama)
    {
      boolean bool = false;
      int j;
      int k;
      int m;
      for (;;)
      {
        try
        {
          j = this.a.k();
          k = this.a.k();
          if ((0x80000000 & j) != 0)
          {
            i = 1;
            m = (0xFF000000 & k) >>> 24;
            k &= 0xFFFFFF;
            if (i == 0) {
              break label258;
            }
            i = (0x7FFF0000 & j) >>> 16;
            if (i == 3) {
              break;
            }
            throw new ProtocolException("version != 3: " + i);
          }
        }
        catch (IOException parama)
        {
          return false;
        }
        int i = 0;
      }
      switch (0xFFFF & j)
      {
      case 5: 
      default: 
        this.a.g(k);
        return true;
      case 1: 
        a(parama, m, k);
        return true;
      case 2: 
        b(parama, m, k);
        return true;
      case 3: 
        c(parama, m, k);
        return true;
      case 4: 
        h(parama, m, k);
        return true;
      case 6: 
        f(parama, m, k);
        return true;
      case 7: 
        g(parama, m, k);
        return true;
      case 8: 
        d(parama, m, k);
        return true;
      }
      e(parama, m, k);
      return true;
      label258:
      if ((m & 0x1) != 0) {
        bool = true;
      }
      parama.a(bool, 0x7FFFFFFF & j, this.a, k);
      return true;
    }
    
    public void close()
    {
      this.c.a();
    }
  }
  
  static final class b
    implements c
  {
    private final g a;
    private final e b;
    private final g c;
    private final boolean d;
    private boolean e;
    
    b(g paramg, boolean paramBoolean)
    {
      this.a = paramg;
      this.d = paramBoolean;
      paramg = new Deflater();
      paramg.setDictionary(ad.a);
      this.b = new e();
      this.c = p.a(new c.j(this.b, paramg));
    }
    
    private void a(List<r> paramList)
    {
      this.c.f(paramList.size());
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        i locali = ((r)paramList.get(i)).h;
        this.c.f(locali.f());
        this.c.b(locali);
        locali = ((r)paramList.get(i)).i;
        this.c.f(locali.f());
        this.c.b(locali);
        i += 1;
      }
      this.c.flush();
    }
    
    public void a() {}
    
    void a(int paramInt1, int paramInt2, e parame, int paramInt3)
    {
      if (this.e) {
        throw new IOException("closed");
      }
      if (paramInt3 > 16777215L) {
        throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + paramInt3);
      }
      this.a.f(0x7FFFFFFF & paramInt1);
      this.a.f((paramInt2 & 0xFF) << 24 | 0xFFFFFF & paramInt3);
      if (paramInt3 > 0) {
        this.a.a_(parame, paramInt3);
      }
    }
    
    public void a(int paramInt1, int paramInt2, List<r> paramList) {}
    
    public void a(int paramInt, long paramLong)
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      if ((paramLong == 0L) || (paramLong > 2147483647L)) {
        throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + paramLong);
      }
      this.a.f(-2147287031);
      this.a.f(8);
      this.a.f(paramInt);
      this.a.f((int)paramLong);
      this.a.flush();
    }
    
    public void a(int paramInt, a parama)
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (parama.t == -1) {
        throw new IllegalArgumentException();
      }
      this.a.f(-2147287037);
      this.a.f(8);
      this.a.f(0x7FFFFFFF & paramInt);
      this.a.f(parama.t);
      this.a.flush();
    }
    
    public void a(int paramInt, a parama, byte[] paramArrayOfByte)
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (parama.u == -1) {
        throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
      }
      this.a.f(-2147287033);
      this.a.f(8);
      this.a.f(paramInt);
      this.a.f(parama.u);
      this.a.flush();
    }
    
    public void a(ac paramac) {}
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      boolean bool2 = true;
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      boolean bool3 = this.d;
      boolean bool1;
      if ((paramInt1 & 0x1) == 1) {
        bool1 = true;
      }
      for (;;)
      {
        if (paramBoolean != bool1) {
          throw new IllegalArgumentException("payload != reply");
        }
        this.a.f(-2147287034);
        this.a.f(4);
        this.a.f(paramInt1);
        this.a.flush();
        return;
        for (;;)
        {
          if (bool3 == bool1) {
            break label130;
          }
          bool1 = bool2;
          break;
          bool1 = false;
        }
        label130:
        bool1 = false;
      }
    }
    
    public void a(boolean paramBoolean, int paramInt1, e parame, int paramInt2)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0) {
        try
        {
          a(paramInt1, i, parame, paramInt2);
          return;
        }
        finally {}
      }
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<r> paramList)
    {
      int j = 0;
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      a(paramList);
      int k = (int)(10L + this.b.b());
      int i;
      if (paramBoolean1) {
        i = 1;
      }
      for (;;)
      {
        this.a.f(-2147287039);
        this.a.f(((j | i) & 0xFF) << 24 | k & 0xFFFFFF);
        this.a.f(paramInt1 & 0x7FFFFFFF);
        this.a.f(paramInt2 & 0x7FFFFFFF);
        this.a.g(0);
        this.a.a(this.b);
        this.a.flush();
        return;
        i = 0;
        if (paramBoolean2) {
          j = 2;
        }
      }
    }
    
    public void b()
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.a.flush();
    }
    
    public void b(ac paramac)
    {
      try
      {
        if (this.e) {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = paramac.b();
      this.a.f(-2147287036);
      this.a.f(i * 8 + 4 & 0xFFFFFF | 0x0);
      this.a.f(i);
      i = 0;
      for (;;)
      {
        if (i <= 10)
        {
          if (paramac.a(i))
          {
            int j = paramac.c(i);
            this.a.f((j & 0xFF) << 24 | i & 0xFFFFFF);
            this.a.f(paramac.b(i));
          }
        }
        else
        {
          this.a.flush();
          return;
        }
        i += 1;
      }
    }
    
    public int c()
    {
      return 16383;
    }
    
    public void close()
    {
      try
      {
        this.e = true;
        b.a.j.a(this.a, this.c);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
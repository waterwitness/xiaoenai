package b.a.b;

import b.a;
import b.a.i;
import b.ab;
import b.at;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class u
{
  private final a a;
  private final i b;
  private Proxy c;
  private InetSocketAddress d;
  private List<Proxy> e = Collections.emptyList();
  private int f;
  private List<InetSocketAddress> g = Collections.emptyList();
  private int h;
  private final List<at> i = new ArrayList();
  
  public u(a parama, i parami)
  {
    this.a = parama;
    this.b = parami;
    a(parama.a(), parama.h());
  }
  
  static String a(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private void a(ab paramab, Proxy paramProxy)
  {
    if (paramProxy != null) {
      this.e = Collections.singletonList(paramProxy);
    }
    for (;;)
    {
      this.f = 0;
      return;
      this.e = new ArrayList();
      paramab = this.a.g().select(paramab.a());
      if (paramab != null) {
        this.e.addAll(paramab);
      }
      this.e.removeAll(Collections.singleton(Proxy.NO_PROXY));
      this.e.add(Proxy.NO_PROXY);
    }
  }
  
  private void a(Proxy paramProxy)
  {
    this.g = new ArrayList();
    Object localObject;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      localObject = this.a.a().f();
    }
    InetSocketAddress localInetSocketAddress;
    for (int j = this.a.a().g(); (j < 1) || (j > 65535); j = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + (String)localObject + ":" + j + "; port is out of range");
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = a(localInetSocketAddress);
    }
    if (paramProxy.type() == Proxy.Type.SOCKS) {
      this.g.add(InetSocketAddress.createUnresolved((String)localObject, j));
    }
    for (;;)
    {
      this.h = 0;
      return;
      paramProxy = this.a.b().a((String)localObject);
      int m = paramProxy.size();
      int k = 0;
      while (k < m)
      {
        localObject = (InetAddress)paramProxy.get(k);
        this.g.add(new InetSocketAddress((InetAddress)localObject, j));
        k += 1;
      }
    }
  }
  
  private boolean c()
  {
    return this.f < this.e.size();
  }
  
  private Proxy d()
  {
    if (!c()) {
      throw new SocketException("No route to " + this.a.a().f() + "; exhausted proxy configurations: " + this.e);
    }
    Object localObject = this.e;
    int j = this.f;
    this.f = (j + 1);
    localObject = (Proxy)((List)localObject).get(j);
    a((Proxy)localObject);
    return (Proxy)localObject;
  }
  
  private boolean e()
  {
    return this.h < this.g.size();
  }
  
  private InetSocketAddress f()
  {
    if (!e()) {
      throw new SocketException("No route to " + this.a.a().f() + "; exhausted inet socket addresses: " + this.g);
    }
    List localList = this.g;
    int j = this.h;
    this.h = (j + 1);
    return (InetSocketAddress)localList.get(j);
  }
  
  private boolean g()
  {
    return !this.i.isEmpty();
  }
  
  private at h()
  {
    return (at)this.i.remove(0);
  }
  
  public void a(at paramat, IOException paramIOException)
  {
    if ((paramat.b().type() != Proxy.Type.DIRECT) && (this.a.g() != null)) {
      this.a.g().connectFailed(this.a.a().a(), paramat.b().address(), paramIOException);
    }
    this.b.a(paramat);
  }
  
  public boolean a()
  {
    return (e()) || (c()) || (g());
  }
  
  public at b()
  {
    Object localObject;
    if (!e()) {
      if (!c())
      {
        if (!g()) {
          throw new NoSuchElementException();
        }
        localObject = h();
      }
    }
    at localat;
    do
    {
      return (at)localObject;
      this.c = d();
      this.d = f();
      localat = new at(this.a, this.c, this.d);
      localObject = localat;
    } while (!this.b.c(localat));
    this.i.add(localat);
    return b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */